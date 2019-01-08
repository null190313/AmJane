package org.lxrookie.start.substance.controller;


import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.lxrookie.cloud.annotations.ClientAnnotation;
import org.lxrookie.start.substance.base.controller.BaseController;
import org.lxrookie.start.substance.constant.SMSPlatformConstant;
import org.lxrookie.start.substance.constant.SysConfigConstant;
import org.lxrookie.start.substance.entity.SysPhoneMessageEntity;
import org.lxrookie.start.substance.entity.UserBaseMessageEntity;
import org.lxrookie.start.substance.entity.UserBaseProfessionalEntity;
import org.lxrookie.start.substance.services.obj.SysPhoneMessageServices;
import org.lxrookie.start.substance.services.obj.UserBaseMessageServices;
import org.lxrookie.start.substance.services.obj.UserBaseProfessionalServices;
import org.lxrookie.start.substance.services.total.ObjectToAssembleServices;
import org.lxrookie.start.substance.services.total.VerificationCodeServices;
import org.lxrookie.start.substance.util.JedisUtils;
import org.lxrookie.start.substance.util.NumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ------------------------------.
 *
 * @author : 沐惜
 * @ClassName : RegistorController
 * @createTime : 2018/11/26 11:04
 * @描述 : 注册请求
 * @Version : 1.0
 * ------------------------------
 */
@Controller
@RequestMapping(value = "/entryGlobal")
public class RegistorController extends BaseController {

    private Logger logger = Logger.getLogger(RegistorController.class);

    @Autowired
    private UserBaseProfessionalServices userBaseProfessionalServices;
    @Autowired
    private VerificationCodeServices verificationCodeServices;
    @Autowired
    private UserBaseMessageServices userBaseMessageServices;
    @Autowired
    private SysPhoneMessageServices sysPhoneMessageServices;
    @Autowired
    private ObjectToAssembleServices objectToAssembleServices;

    /**
     * ------------------------------.
     *
     * @name : RegistorController
     * @author : 沐惜
     * @createTime : 2018/12/8 12:32
     * @description : 注册页面
     * @Version : 1.0
     * ------------------------------
     */
    @ClientAnnotation(client = "CLIENT.PLA", isLogin = "NOTALLOW.LO")
    @RequestMapping(value = "/registered.html",method = RequestMethod.GET)
    public ModelAndView registered() {
        ModelAndView modelAndView = new ModelAndView("pc/register/NG_registration");
        List<UserBaseProfessionalEntity> UserBaseMessageProfessionalEntityLists = userBaseProfessionalServices.selectAllUserBaseProfessional();
        modelAndView.addObject("professionals", UserBaseMessageProfessionalEntityLists);
        basicDataLoading(modelAndView);
        return modelAndView;
    }

    /**
     * ------------------------------.
     * @name : RegistorController
     * @author : 沐惜
     * @Param : userBaseMessageEntity 用户注册填写信息
     * @Return : Map 注册信息检测结果
     * @createTime : 2018/12/9 16:31
     * @description : TODO
     * @Version : 1.0
     * ------------------------------
     */
    @RequestMapping(value = "checkRegisInfo.do", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, String> registeredCheckInformation(UserBaseMessageEntity userBaseMessageEntity) {
        Map<String, String> returnMap = userBaseMessageServices.registeredCheckInformation(userBaseMessageEntity);
        return returnMap;
    }

    /**
     *------------------------------.
     * @name : RegistorController
     * @author : 沐惜
     * @createTime : 2018/12/24 12:51
     * @description : 发送验证码
     * @Version : 1.0
     *------------------------------
     */
    @RequestMapping(value = "/achieveSMSCheckInfo.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, String> achieveSMSCheckInfo(@RequestParam(required = false) String nickName,
                                                   @RequestParam(required = false) String firstPassword,
                                                   @RequestParam(required = false) String secondPassword,
                                                   @RequestParam(required = false) String userPhone) {
        Map<String, String> returnMap = userBaseMessageServices.achieveSMSCheckInfo(nickName,firstPassword,secondPassword,userPhone);
        return returnMap;
    }

    /**
     * ------------------------------.
     *
     * @name : RegistorController
     * @author : 沐惜
     * @createTime : 2018/12/19 10:52
     * @description : TODO
     * @Version : 1.0 获取注册验证码
     * ------------------------------
     */
    @RequestMapping(value = "/sendSMS.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, String> sendSMS(@RequestParam(required = true) String phone) {
        Map<String, String> returnMap = new HashMap<String, String>();
        /**
         * 获取当前手机号的注册码
         * */
        String ranCode = NumUtils.pickBitsRandom();
        String[] phones = new String[]{phone};
        String[] paramgs = new String[]{ranCode, "5"};
        /**
         * 发送验证码
         * */
        String smsCode = verificationCodeServices.sendTencentMessageCode(phones, SMSPlatformConstant.TEMPLATEID_REGISTER, paramgs);
        sysPhoneMessageServices.insertSysPhoneMessage(
                objectToAssembleServices.assembleSysPhoneMessage(new SysPhoneMessageEntity(),phone,
                SMSPlatformConstant.TEMPLATEID_REGISTER_CONTENT_BEFORE+smsCode+SMSPlatformConstant.TEMPLATEID_REGISTER_CONTENT_AFTER,
                        "",0));
        /**
         * 存储验证码至Redis  持续时间300s
         * */
        JedisUtils.set(SMSPlatformConstant.TEMPLATEID_REGISTER + phone, smsCode, 300);
        returnMap.put("state", "success");
        returnMap.put("detectionCode", "1");
        returnMap.put("detectionMessage", ranCode);
        return returnMap;
    }

    @RequestMapping(value = "/checkInfoIsRepeat.do", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String,String> checkInfoIsRepeat(@RequestParam(required = false) String nickName,
                                                @RequestParam(required = false) String firstPassword,
                                                @RequestParam(required = false) String secondPassword,
                                                @RequestParam(required = false) String userPhone){
            return userBaseMessageServices.checkInfoIsRepeat(nickName,firstPassword,secondPassword,userPhone);
    }

}

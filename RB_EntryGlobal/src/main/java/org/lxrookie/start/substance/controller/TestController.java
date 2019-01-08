package org.lxrookie.start.substance.controller;


import net.sf.json.JSONObject;
import org.lxrookie.start.substance.constant.SMSPlatformConstant;
import org.lxrookie.start.substance.entity.LogRecordEntity;
import org.lxrookie.start.substance.entity.SysConfigEntity;
import org.lxrookie.start.substance.entity.UserBaseProfessionalEntity;
import org.lxrookie.start.substance.services.feignclient.EurekaLogsServicesClient;
import org.lxrookie.start.substance.services.obj.LogRecordServices;
import org.lxrookie.start.substance.services.obj.SysConfigServices;
import org.lxrookie.start.substance.services.obj.UserBaseProfessionalServices;
import org.lxrookie.start.substance.services.total.VerificationCodeServices;
import org.lxrookie.start.substance.util.JedisUtils;
import org.lxrookie.start.substance.util.NumUtils;
import org.lxrookie.start.substance.util.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *------------------------------.
 *@MethodName : TestController
 *@author : 沐惜
 *@createTime : 2018/11/11 18:35
 *@描述 : TODO
 *@Version : 1.0
 *------------------------------
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/entryGlobal")
public class TestController {

    @Autowired
    private JedisPool jedisPool;

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/hello.html")
    public ModelAndView index(HttpServletRequest request , Model model) {
        request.getSession().setAttribute("session","sesison共享");
        System.out.printf("========================================");
        return new ModelAndView("pc/register/NG_registration");
    }

    @RequestMapping(value = "/hello1.html")
    public ModelAndView index2() {
        System.out.printf("========================================");
        return new ModelAndView("pc/login/NG_login");
    }

    @RequestMapping(value = "/hello3.html")
    public ModelAndView index1() {
        System.out.printf("========================================");
        return new ModelAndView("pc/common/sub/NG_popularPic");
    }


    @GetMapping("/welcome")
    public ModelAndView welcome() {
        return new ModelAndView("pc/register/NG_registration");
    }


    @RequestMapping(value = "/redisTest.html")
    public ModelAndView redisTest(){
        Jedis jedis = jedisPool.getResource();
        jedis.set("key1","testRedis1");
        System.out.printf("从redis取出成功   "+jedis.get("key1"));
        return new ModelAndView("pc/register/NG_registration");
    }
    @RequestMapping(value = "/redisTest2.html")
    public void redisTest2(){
        JedisUtils.set("key1","value1",1000);
        System.out.println("存入成功");
        System.out.println(JedisUtils.get("key1"));
    }

    /**
     * 删除用户
     * @param id  用户编号
     *  *@return
     */
    @DeleteMapping(value = "/user/{id}")
    public  void deleteUser(@PathVariable("id") Integer id){
        System.out.printf(id.toString());
    }

    @PutMapping(value = "/user/{id}")
    public String updateUser(@PathVariable("id") Integer id, @RequestParam("name") String name,
                             @RequestParam("age") int age, @RequestParam("country") String country){

        return id.toString();
    }



    @Autowired
    private LogRecordServices logRecordServices;

    @Autowired
    private EurekaLogsServicesClient eurekaLogsServicesClient;

    @RequestMapping(value="/cloudTest.html", method = RequestMethod.GET)
    public ModelAndView userInfo() {
        LogRecordEntity logRecordEntity = logRecordServices.selectLogRecordListsById("da79373dff554d858a7cc042eaaae4f4");
        JSONObject jsonObject = JSONObject.fromObject(logRecordEntity);
        System.out.println(jsonObject.toString());
        String message = eurekaLogsServicesClient.theUserLoginRecord(jsonObject.toString());
        System.out.println(message);
        return new ModelAndView("pc/common/sub/NG_popularPic");
    }


    @RequestMapping(value = "/testFeginClient",method = RequestMethod.GET)
    public void testClient(){
        String message = eurekaLogsServicesClient.testCloudFeignClient("测试");
        System.out.println(message);
    }

    @Autowired
    private SysConfigServices sysConfigServices;
    @RequestMapping(value = "/sysConfig.html",method = RequestMethod.GET)
    public ModelAndView sysConfig(SysConfigEntity sysConfigEntity){
        return new ModelAndView("test/sysConfig");
    }



    @RequestMapping(value = "/insertSysConfig.html")
    public String insertSysConfig(){
        SysConfigEntity sysConfigEntity = new SysConfigEntity();
            sysConfigEntity.setSysConfigId(UUIDUtils.uuid());
            sysConfigEntity.setSysConfigKey("SharingLocation");
            sysConfigEntity.setSysConfigValue("http://www.rookieboy.cn:81/sharing/");
            sysConfigEntity.setSysConfigCreateTime(new Date());
            sysConfigEntity.setSysConfigState(0);
            sysConfigEntity.setSysConfigDescription("上传下载分享(数据分享)系统");
            sysConfigServices.insertSysConfigObj(sysConfigEntity);
        return  "redirect:sysConfig.html";
    }
    @Autowired
    private UserBaseProfessionalServices userBaseProfessionalServices;
    @RequestMapping(value = "/insertUserBasePro.html")
    public String insertUserBasePro(){
        UserBaseProfessionalEntity userBaseMessageProfessionalEntity = new UserBaseProfessionalEntity();
        List<String> lists = new ArrayList<>();
        lists.add("学生");
        lists.add("UI设计");
        lists.add("视觉设计");
        lists.add("内容运营");
        lists.add("产品运营");
        lists.add("数据运营");
        lists.add("活动运营");
        lists.add("商家运营");
        lists.add("游戏运营");
        lists.add("前端开发");
        lists.add("后台开发");
        lists.add("移动开发");
        lists.add("硬件开发");
        lists.add("测试");
        for (String str:
             lists) {
            userBaseMessageProfessionalEntity.setUserProfessionalId(UUIDUtils.uuid());
            userBaseMessageProfessionalEntity.setUserProfessional(str);
            userBaseMessageProfessionalEntity.setUserCreateTime(new Date());
            userBaseMessageProfessionalEntity.setUserState(0);
            userBaseProfessionalServices.insertUserBaseProfessional(userBaseMessageProfessionalEntity);
        }


        return null;
    }


    @Autowired
    private VerificationCodeServices verificationCodeServices;



    @RequestMapping(value = "/testSMS.html")
    public void testSMS(){
        System.out.println("开始发送");
        String[] phones = new String[]{"13213731716"};
        String[] params = new String[]{ NumUtils.pickBitsRandom(),"5"};
        System.out.println(verificationCodeServices.sendTencentMessageCode(phones, SMSPlatformConstant.TEMPLATEID_LOGIN,params));
        System.out.println(verificationCodeServices.sendTencentMessageCode(phones, SMSPlatformConstant.TEMPLATEID_REGISTER,params));
        System.out.println("发送成功");
    }




}

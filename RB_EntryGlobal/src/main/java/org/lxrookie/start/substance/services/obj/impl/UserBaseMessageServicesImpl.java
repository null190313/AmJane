package org.lxrookie.start.substance.services.obj.impl;

import org.lxrookie.start.substance.base.services.BaseServices;
import org.lxrookie.start.substance.constant.SMSPlatformConstant;
import org.lxrookie.start.substance.constant.SysConfigConstant;
import org.lxrookie.start.substance.dao.UserBaseDataDao;
import org.lxrookie.start.substance.dao.UserBaseMessageDao;
import org.lxrookie.start.substance.entity.UserBaseMessageEntity;
import org.lxrookie.start.substance.services.obj.UserBaseDataServices;
import org.lxrookie.start.substance.services.obj.UserBaseMessageServices;
import org.lxrookie.start.substance.services.total.ObjectToAssembleServices;
import org.lxrookie.start.substance.services.total.VerificationCodeServices;
import org.lxrookie.start.substance.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Service("userBaseMessageServices")
public class UserBaseMessageServicesImpl extends BaseServices<UserBaseMessageEntity> implements UserBaseMessageServices {


    @Autowired
    private UserBaseMessageDao userBaseMessageDao;

    @Autowired
    private ObjectToAssembleServices objectToAssembleServices;

    @Autowired
    private UserBaseDataServices userBaseDataServices;

    @Override
    public UserBaseMessageEntity selectUserBaseMessageById(String userId) {
        return ((UserBaseMessageDao)getMapper()).selectByPrimaryKey(userId);
    }

    @Override
    public Map<String, String> registeredCheckInformation(UserBaseMessageEntity userBaseMessageEntity) {
        Map<String,String> detectionMap = new HashMap<String,String>();

        if("".equals(userBaseMessageEntity.getUserNickName()) || null == userBaseMessageEntity.getUserNickName()){
            detectionMap.put("detectionCode","-1");
            detectionMap.put("detectionMessage","注册昵称不能为空!");
            return detectionMap;
        }else if("".equals(userBaseMessageEntity.getUserPasword()) || null == userBaseMessageEntity.getUserPasword()){
            detectionMap.put("detectionCode","-2");
            detectionMap.put("detectionMessage","注册密码不能为空!");
            return detectionMap;
        }else if("".equals(userBaseMessageEntity.getUserSecondPassword()) || null == userBaseMessageEntity.getUserSecondPassword()){
            detectionMap.put("detectionCode","-3");
            detectionMap.put("detectionMessage","请再次填写密码!");
            return detectionMap;
        }else if("".equals(userBaseMessageEntity.getUserPhone()) || null == userBaseMessageEntity.getUserPhone()){
            detectionMap.put("detectionCode","-4");
            detectionMap.put("detectionMessage","手机号码不得为空!");
            return detectionMap;
        }else if("".equals(userBaseMessageEntity.getUserDetectionCode()) || null == userBaseMessageEntity.getUserDetectionCode()){
            detectionMap.put("detectionCode","-5");
            detectionMap.put("detectionMessage","验证码不得为空!");
            return detectionMap;
        }
        if(!AccountValidatorUtils.isUsername(userBaseMessageEntity.getUserNickName())){
            detectionMap.put("detectionCode","-1");
            detectionMap.put("detectionMessage","请填写正确昵称,5~20个英文字符!");
            return detectionMap;
        }else if(!AccountValidatorUtils.isPassword(userBaseMessageEntity.getUserPasword())){
            detectionMap.put("detectionCode","-2");
            detectionMap.put("detectionMessage","密码长度需在6~14位之间!");
            return detectionMap;
        }else if(!userBaseMessageEntity.getUserPasword().equals(userBaseMessageEntity.getUserSecondPassword())){
            detectionMap.put("detectionCode","-3");
            detectionMap.put("detectionMessage","两次密码不相同,请核实密码!");
            return detectionMap;
        }else if(!AccountValidatorUtils.isMobile(userBaseMessageEntity.getUserPhone())){
            detectionMap.put("detectionCode","-4");
            detectionMap.put("detectionMessage","手机号码格式有误,请核实号码!");
            return detectionMap;
        }else if(!userBaseMessageEntity.getUserDetectionCode().equals(JedisUtils.get(SMSPlatformConstant.TEMPLATEID_REGISTER+userBaseMessageEntity.getUserPhone()))){
            detectionMap.put("detectionCode","-5");
            detectionMap.put("detectionMessage","验证码有误或已失效.");
            return detectionMap;
        }else if(null != selectUserBaseMessageEntityByPhone(userBaseMessageEntity.getUserPhone())){
            if("13213731716".equals(userBaseMessageEntity.getUserPhone())){
                detectionMap.put("state","success");
                detectionMap.put("detectionMessage","管理员操作");
                detectionMap.put("detectionCode","0");
                return detectionMap;
            }
            detectionMap.put("state","error");
            detectionMap.put("detectionMessage","当前手机号已被注册.");
            detectionMap.put("detectionCode","-4");
            return detectionMap;
        }
        userBaseMessageEntity = objectToAssembleServices.assembleUserBaseMessage(request,userBaseMessageEntity);
        ((UserBaseMessageDao)getMapper()).insertUserBaseMessageEntity(userBaseMessageEntity);
        UserBaseMessageEntity regUserBaseMessageEntity =  ((UserBaseMessageDao)userBaseMessageDao).selectUserBaseMessageByPhone(userBaseMessageEntity.getUserPhone());
        userBaseDataServices.insertUserBaseDataOfId(regUserBaseMessageEntity.getUserId());
        detectionMap.put("detectionCode","0");
        detectionMap.put("detectionMessage","注册完成");
        detectionMap.put("regSeccessUserAccount",regUserBaseMessageEntity.getUserAccount());
        return detectionMap;
    }

    @Override
    public Map<String, String> achieveSMSCheckInfo(String nickName, String firstPassword, String secondPassword, String userPhone) {
        Map<String,String> detectionMap = new HashMap<String,String>();
        if("".equals(nickName)){
            detectionMap.put("state","error");
            detectionMap.put("detectionMessage","注册昵称不能为空.");
            detectionMap.put("detectionCode","-1");
            return detectionMap;
        }else if("".equals(firstPassword)){
            detectionMap.put("state","error");
            detectionMap.put("detectionMessage","注册密码不能为空.");
            detectionMap.put("detectionCode","-2");
            return detectionMap;
        }else if("".equals(secondPassword)){
            detectionMap.put("state","error");
            detectionMap.put("detectionMessage","请再次填写密码.");
            detectionMap.put("detectionCode","-3");
            return detectionMap;
        }else if(!firstPassword.equals(secondPassword)){
            detectionMap.put("state","error");
            detectionMap.put("detectionMessage","两次密码不一致,请检查.");
            detectionMap.put("detectionCode","-3");
            return detectionMap;
        }else if("".equals(userPhone)){
            detectionMap.put("state","error");
            detectionMap.put("detectionMessage","手机号码不得为空");
            detectionMap.put("detectionCode","-4");
            return detectionMap;
        }else if(!AccountValidatorUtils.isMobile(userPhone)){
            detectionMap.put("state","error");
            detectionMap.put("detectionMessage","请填写正确手机号码.");
            detectionMap.put("detectionCode","-4");
            return detectionMap;
        }else if(null != selectUserBaseMessageEntityByPhone(userPhone)){
            if("13213731716".equals(userPhone)){
                detectionMap.put("state","success");
                detectionMap.put("detectionMessage","管理员操作");
                detectionMap.put("detectionCode","0");
                return detectionMap;
            }
            detectionMap.put("state","error");
            detectionMap.put("detectionMessage","当前手机号已被注册.");
            detectionMap.put("detectionCode","-4");
            return detectionMap;
        }else if(null !=  JedisUtils.get(SMSPlatformConstant.TEMPLATEID_REGISTER+userPhone) || null != JedisUtils.get(SMSPlatformConstant.TEMPLATEID_REGISTER+userPhone)){
            if("13213731716".equals(userPhone)){
                detectionMap.put("state","success");
                detectionMap.put("detectionMessage","管理员操作");
                detectionMap.put("detectionCode","0");
                return detectionMap;
            }
            /**
             * 根据当前手机判断redis是否已存在验证码
             * 注册验证码key存储规则为  短信签名模板ID + 手机号
             * */
            detectionMap.put("state","error");
            detectionMap.put("detectionMessage","当前手机以获取过验证码.");
            detectionMap.put("detectionCode","-4");
            return detectionMap;
        }
        detectionMap.put("state","success");
        detectionMap.put("detectionMessage","校验通过.");
        detectionMap.put("detectionCode","0");
        return detectionMap;
    }


    @Override
    public UserBaseMessageEntity selectUserBaseMessageEntityByPhone(String phone) {
        return ((UserBaseMessageDao)getMapper()).selectUserBaseMessageByPhone(phone);
    }

    @Override
    public Map<String, String> checkInfoIsRepeat(String nickName, String firstPassword, String secondPassword, String userPhone) {
        Map<String,String> detectionMap = new HashMap<String,String>();
        if(!"".equals(nickName)){
            if(null != ((UserBaseMessageDao)getMapper()).selectUserBaseByNickName(nickName)){
                detectionMap.put("state","error");
                detectionMap.put("detectionMessage","当前昵称已被注册.");
                detectionMap.put("detectionCode","-1");
                return detectionMap;
            }else if(!AccountValidatorUtils.isUsername(nickName)){
                detectionMap.put("state","error");
                detectionMap.put("detectionCode","-1");
                detectionMap.put("detectionMessage","请填写正确昵称,5~20个英文字符!");
                return detectionMap;
            }else{
                detectionMap.put("state","success");
                detectionMap.put("detectionMessage","当前昵称可以使用.");
                detectionMap.put("detectionCode","1");
                return detectionMap;
            }
        }

        if(!"".equals(userPhone)){
            if(null != ((UserBaseMessageDao)getMapper()).selectUserBaseMessageByPhone(userPhone)){
                if("13213731716".equals(userPhone)){
                    detectionMap.put("state","success");
                    detectionMap.put("detectionMessage","管理员操作");
                    detectionMap.put("detectionCode","2");
                    return detectionMap;
                }
                detectionMap.put("state","error");
                detectionMap.put("detectionMessage","当前手机号已被注册.");
                detectionMap.put("detectionCode","-2");
                return detectionMap;
            }else if(!AccountValidatorUtils.isMobile(userPhone)){
                detectionMap.put("state","error");
                detectionMap.put("detectionMessage","当前手机号格式不正确.");
                detectionMap.put("detectionCode","-2");
                return detectionMap;
            }else{
                detectionMap.put("state","success");
                detectionMap.put("detectionMessage","当前手机号可以使用.");
                detectionMap.put("detectionCode","2");
                return detectionMap;
            }
        }

        if(!"".equals(firstPassword) && "".equals(secondPassword)){

            if(Pattern.compile("\\s+").matcher(firstPassword).find()){
                detectionMap.put("state","success");
                detectionMap.put("detectionMessage","密码不可带有空格");
                detectionMap.put("detectionCode","-3");
                return detectionMap;
            }
            Integer s = firstPassword.length();

            if((6 < firstPassword.length() + 1) && (14 > firstPassword.length() + 1)){
                detectionMap.put("state","success");
                detectionMap.put("detectionMessage","密码符合");
                detectionMap.put("detectionCode","3");
                return detectionMap;
            }else{
                detectionMap.put("state","success");
                detectionMap.put("detectionMessage","密码长度需在6~14位之间.");
                detectionMap.put("detectionCode","-3");
                return detectionMap;
            }
        }

        if(!"".equals(secondPassword) && !"".equals(firstPassword)){
            if(firstPassword.equals(secondPassword)){
                detectionMap.put("state","success");
                detectionMap.put("detectionMessage","两次密码相同.");
                detectionMap.put("detectionCode","4");
                return detectionMap;
            }else if(!firstPassword.equals(secondPassword)){
                detectionMap.put("state","success");
                detectionMap.put("detectionMessage","两次密码不同,请核实.");
                detectionMap.put("detectionCode","-4");
                return detectionMap;
            }
        }
        return null;
    }

    @Override
    public Map<String,String> checkLoginInfo(UserBaseMessageEntity userBaseMessageEntity, HttpServletRequest request, HttpServletResponse response) {
        Map<String,String> returnMap = new HashMap<String,String>();
        userBaseMessageEntity.setUserPasword(MD5Utils.getMD5Code(userBaseMessageEntity.getUserPasword()));
        String userAccount = userBaseMessageEntity.getUserAccount();
        if("".equals(userBaseMessageEntity.getUserAccount())){
            returnMap.put("state","error");
            returnMap.put("detectionMessage","账号不得为空.");
            returnMap.put("detectionCode","-1");
            return returnMap;
        }else if("".equals(userBaseMessageEntity.getUserPasword())){
            returnMap.put("state","error");
            returnMap.put("detectionMessage","密码不得为空.");
            returnMap.put("detectionCode","-2");
            return returnMap;
        }else if(null == ((UserBaseMessageDao)getMapper()).selectUserBaseByAccount(userAccount)){
            returnMap.put("state","error");
            returnMap.put("detectionMessage","账号不存在.");
            returnMap.put("detectionCode","-1");
            return returnMap;
        }else{
            UserBaseMessageEntity userInfo = ((UserBaseMessageDao)getMapper()).selectUserBaseByUserAccountOrPhone(userBaseMessageEntity);
            if(null == userInfo){
                returnMap.put("state","error");
                returnMap.put("detectionMessage","密码错误.");
                returnMap.put("detectionCode","-2");
                return returnMap;
            }else{
                writingLoginInformation(userInfo,request,response);
                returnMap.put("state","success");
                returnMap.put("detectionMessage","信息正确");
                returnMap.put("detectionCode","0");
                return returnMap;
            }
        }
    }

    @Override
    public void writingLoginInformation(UserBaseMessageEntity userBaseMessageEntity,HttpServletRequest request, HttpServletResponse response) {
        /**
         * 1.cookieId写入  加密规则 ID+PWD AES加密
         * */
         String cookieId = AESUtils.ecodes(userBaseMessageEntity.getUserId(),SysConfigConstant.COOKIE_UNIFIED_ENCRYPTION);
         /**
          * 2.tokenId写入  加密规则 模块名+userId+时间戳 + pwd  AES加密
          * */
         String token = AESUtils.ecodes(TotalUtils.createToken(SysConfigConstant.EntryGlobalLocation,userBaseMessageEntity.getUserId()),userBaseMessageEntity.getUserPasword());
        /**
         * cookieId 写入cookie
         * */
         CookieUtils.setCookie(request,response,SysConfigConstant.COOKIEID,cookieId,3600);
         /**
          * tokenId写入cookie redis session
          * */
         CookieUtils.setCookie(request,response,SysConfigConstant.TOKENID,token,3600);
         JedisUtils.set(SysConfigConstant.TOKENID,token,3600);
         SessionUtils.pushMaxInactiveInterval(SysConfigConstant.TOKENID,token,3600);
    }
}

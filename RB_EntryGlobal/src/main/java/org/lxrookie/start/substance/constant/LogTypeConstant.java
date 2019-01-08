package org.lxrookie.start.substance.constant;

import org.lxrookie.start.substance.entity.LogTypeEntity;
import org.lxrookie.start.substance.util.obj.LogTypeUtils;

/**
 *------------------------------.
 * @name : LogTypeConstant
 * @author : 沐惜
 * @createTime : 2018/11/27 22:03
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
public class LogTypeConstant {
    /**
     * 用户登录成功
     */
    public static final LogTypeEntity USER_LOGIN_SUCCESS = LogTypeUtils.getLogTypeEntityByKey("USER_LOGIN_SECCESS");
    /**
     * 用户登录:手机验证码正确
     */
    public static final LogTypeEntity USER_LOGIN_SUCCESS_PHONE_CODE = LogTypeUtils.getLogTypeEntityByKey("USER_LOGIN_SUCCESS_PHONE_CODE");
    /**
     * 用户登录:邮箱验证码正确
     */
    public static final LogTypeEntity USER_LOGIN_SUCCESS_EAMIL_CODE = LogTypeUtils.getLogTypeEntityByKey("USER_LOGIN_SUCCESS_EAMIL_CODE");
    /**
     * 用户登录失败:密码错误
     */
    public static final LogTypeEntity USER_LOGIN_ERROR_PASS = LogTypeUtils.getLogTypeEntityByKey("USER_LOGIN_ERROR_PASS");
    /**
     * 用户登录失败:用户已被封禁
     */
    public static final LogTypeEntity USER_LOGIN_BANNED = LogTypeUtils.getLogTypeEntityByKey("USER_LOGIN_BANNED");
    /**
     * 用户登录失败
     */
    public static final LogTypeEntity USER_LOGIN_ERROR = LogTypeUtils.getLogTypeEntityByKey("USER_LOGIN_ERROR");
    /**
     * 用户登录失败:身份验证失败
     */
    public static final LogTypeEntity USER_LOGIN_ERROR_AUTHENTICATION = LogTypeUtils.getLogTypeEntityByKey("USER_LOGIN_ERROR_AUTHENTICATION");
    /**
     * 用户注册失败
     */
    public static final LogTypeEntity USER_REGISTER_SEUUESS = LogTypeUtils.getLogTypeEntityByKey("USER_REGISTER_SEUUESS");
    /**
     * 用户注册失败
     */
    public static final LogTypeEntity USER_REGISTER_ERROR = LogTypeUtils.getLogTypeEntityByKey("USER_REGISTER_ERROR");
    /**
     * 用户注册错误:手机验证码错误
     */
    public static final LogTypeEntity USER_REGISTER_ERROR_PHONE_CODE = LogTypeUtils.getLogTypeEntityByKey("USER_REGISTER_ERROR_PHONE_CODE");
    /**
     * 用户注册错误:邮箱验证码错误
     */
    public static final LogTypeEntity USER_REGISTER_ERROR_EAMIL_CODE = LogTypeUtils.getLogTypeEntityByKey("USER_REGISTER_ERROR_EAMIL_CODE");

    
}

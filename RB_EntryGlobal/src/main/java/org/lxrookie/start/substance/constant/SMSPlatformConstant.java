package org.lxrookie.start.substance.constant;

/**
 * ------------------------------.
 *
 * @author : 沐惜
 * @name : SMSPlatformConstant
 * @createTime : 2018/12/10 16:32
 * @description : 短信平台API SDK 静态属性
 * @Version : 1.0
 * ------------------------------
 */
public class SMSPlatformConstant {


        /**
         * SDK APPID
         * */
        public final static int SMS_SKD_APPID = 1400167746;

        /**
         * SDK APP KEY
         * */
        public final static String SMS_APP_KEY  = "a8ab8a8c34bce78ba3e297fe514d40ec";

        /**
         * 签名  签名内容
         * */
        public final static String SMS_SIGN = "it技术爱好菜鸟集中营";


        /**
         * 登录短信模板ID，需要在短信应用中申请
         * */
        public static int TEMPLATEID_LOGIN = 261280;

        /**
         * 注册短信模板ID，需要在短信应用中申请
         * */
        public static int TEMPLATEID_REGISTER = 250870;

        /**
         * 注册短信模板内容_前,根据腾讯云注册短信模板ID对应的正文内容
         * */
        public static String TEMPLATEID_REGISTER_CONTENT_BEFORE = "您的注册验证码是：";

        /**
         * 注册短信模板内容_后,根据腾讯云注册短信模板ID对应的正文内容
         * */
        public static String TEMPLATEID_REGISTER_CONTENT_AFTER = "验证码有效期为5分钟。请不要把验证码泄漏给其他人。如非本人操作，请忽略本短信。";

        /**
         * 登录短信模板内容_前,根据腾讯云注册短信模板ID对应的正文内容
         * */
        public static String TEMPLATER_LOGIN_BEFORE = "您的登录验证码是：";

        /**
         * 登录短信模板内容_后,根据腾讯云注册短信模板ID对应的正文内容
         * */
        public static String TEMPLATER_LOGIN_AFTER = "验证码有效期为5分钟。请不要把验证码泄漏给其他人。如非本人操作，请忽略本短信。";




        /**
         * 用户验证码存入RedisKey公用部分
         * */
        public final static String REGISTER_VERIFICATION_CODE = "Register";







}

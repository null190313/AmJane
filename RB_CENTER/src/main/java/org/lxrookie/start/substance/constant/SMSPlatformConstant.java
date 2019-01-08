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
        public static int TEMPLATEID_LOGIN = 250869;

        /**
         * 注册短信模板ID，需要在短信应用中申请
         * */
        public static int TEMPLATEID_REGISTER = 250870;



        /**
         * 用户验证码存入RedisKey公用部分
         * */
        public final static String REGISTER_VERIFICATION_CODE = "Register";



}

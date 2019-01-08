package org.lxrookie.start.substance.constant;


import org.lxrookie.start.substance.util.obj.SysConfigUtils;

/**
 *------------------------------.
 *@ClassName : SysConfigConstant
 *@author : 沐惜
 *@createTime : 2018/11/26 19:52
 *@描述 : SysConfigConstant静态类  库中读取
 *@Version : 1.0
 *------------------------------
 */
public class SysConfigConstant {



        /**
         * cookie存入redis的通用key值 (部分)
         * */
        public static String USER_BASE_REDIS_COOKIEID = "USER_BASE_REDIS_COOKIEID";

        /**
         * cookieId
         * */
        public static String COOKIEID = SysConfigUtils.getSysConfigByKey("User_Base_CookieName_Token");

        /**
         * tooken存入key
         * */
        public static String TOKENID = SysConfigUtils.getSysConfigByKey("User_Base_CookieName_Id");

        /**
         * cookieid统一加密 key
         * */
        public static String COOKIE_UNIFIED_ENCRYPTION = SysConfigUtils.getSysConfigByKey("COOKIE_UNIFIED_ENCRYPTION");

        /**
         * tookieid统一加密 key
         * */
        public static String TOOKEN_UNIFIED_ENCRYPTION = SysConfigUtils.getSysConfigByKey("TOOKEN_UNIFIED_ENCRYPTION");


        /**
         * 跳转统一认证统一参数
         * */
        public static String REDIRECT_CLIENT_ID = SysConfigUtils.getSysConfigByKey("REDIRECT_CLIENT_ID");


        /**
         * EntryGlobalLocat
         * */
        public static  String EntryGlobalLocation = SysConfigUtils.getSysConfigByKey("EntryGlobalLocation");

        /**
         * EntryGlobalLocat
         * */
        public static  String BlogLocation = SysConfigUtils.getSysConfigByKey("BlogLocation");

        /**
         * EntryGlobalLocat
         * */
        public static  String CenterLocation= SysConfigUtils.getSysConfigByKey("CenterLocation");

        /**
         * EntryGlobalLocat
         * */
        public static  String CloudLocation = SysConfigUtils.getSysConfigByKey("CloudLocation");

        /**
         * EntryGlobalLocat
         * */
        public static  String DiaryLocation = SysConfigUtils.getSysConfigByKey("DiaryLocation");

        /**
         * EntryGlobalLocat
         * */
        public static  String LogsLocation = SysConfigUtils.getSysConfigByKey("LogsLocation");
        /**
         * EntryGlobalLocat
         * */
        public static  String NovelLocation = SysConfigUtils.getSysConfigByKey("NovelLocation");

        /**
         * EntryGlobalLocat
         * */
        public static  String SharingLocation = SysConfigUtils.getSysConfigByKey("SharingLocation");

        /**
         * Cookie存储token  key值
         * */
        public static String USER_BASE_COOKIENAME_TOKEN = SysConfigUtils.getSysConfigByKey("User_Base_CookieName_Token");

        /**
         * Cookie存储服务端用户id  key值
         * */
        public static String USER_BASE_COOKIENAME_ID = SysConfigUtils.getSysConfigByKey("User_Base_CookieName_Id");

        /**
         * 用户注册默认头像地址
         * */
        public static String USER_REGISTER_DEFAULT_PIC_URL = SysConfigUtils.getSysConfigByKey("USER_REGISTER_DEFAULT_PIC_URL");



}

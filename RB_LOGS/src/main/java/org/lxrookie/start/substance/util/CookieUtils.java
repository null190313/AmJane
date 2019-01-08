package org.lxrookie.start.substance.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


/**
*------------------------------.
*@ClassName : Cookie 工具类
*@author : 沐惜
*@createTime : 2018/11/14 19:23
*@description : TODO
*@Version : 1.0
*------------------------------
*/
public final class CookieUtils {

    /**
    *------------------------------.
    *@MethodName : getCookieValue
    *@author : 沐惜
    *@createTime : 2018/11/14 19:24
    *@description :  得到Cookie的值, 不编码
    *@param : request cookieName
     *@return :
    *@Version : 1.0
    *------------------------------
    */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        return getCookieValue(request, cookieName, false);
    }

    /**
    *------------------------------.
    *@MethodName : getCookieValue
    *@author : 沐惜
    *@createTime : 2018/11/14 19:24
    *@description : 得到Cookie的值,
    *@param : request cookieName
     *@return :
    *@Version : 1.0
    *------------------------------
    */
    public static String getCookieValue(HttpServletRequest request, String cookieName, boolean isDecoder) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || cookieName == null) {
            return null;
        }
        String retValue = null;
        try {
            for (int i = 0; i < cookieList.length; i++) {
                if (cookieList[i].getName().equals(cookieName)) {
                    if (isDecoder) {
                        retValue = URLDecoder.decode(cookieList[i].getValue(), "UTF-8");
                    } else {
                        retValue = cookieList[i].getValue();
                    }
                    break;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return retValue;
    }


    /**
    *------------------------------.
    *@MethodName : getCookieValue
    *@author : 沐惜
    *@createTime : 2018/11/14 19:24
    *@description : 得到Cookie的值,
    *@param : request cookieName
     *@return :
    *@Version : 1.0
    *------------------------------
    */
    public static String getCookieValue(HttpServletRequest request, String cookieName, String encodeString) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || cookieName == null) {
            return null;
        }
        String retValue = null;
        try {
            for (int i = 0; i < cookieList.length; i++) {
                if (cookieList[i].getName().equals(cookieName)) {
                    retValue = URLDecoder.decode(cookieList[i].getValue(), encodeString);
                    break;
                }
            }
        } catch (UnsupportedEncodingException e) {
        	 e.printStackTrace();
        }
        return retValue;
    }


    /**
    *------------------------------.
    *@MethodName : setCookie
    *@author : 沐惜
    *@createTime : 2018/11/14 19:24
    *@description : 设置Cookie的值 不设置生效时间默认浏览器关闭即失效,也不编码
    *@param :
     *@return :
    *@Version : 1.0
    *------------------------------
    */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue) {
        setCookie(request, response, cookieName, cookieValue, -1);
    }


    /**
    *------------------------------.
    *@MethodName : setCookie
    *@author : 沐惜
    *@createTime : 2018/11/14 19:25
    *@description : 设置Cookie的值 在指定时间内生效,但不编码
    *@param :
     *@return :
    *@Version : 1.0
    *------------------------------
    */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, int cookieMaxage) {
        setCookie(request, response, cookieName, cookieValue, cookieMaxage, false);
    }

    /**
    *------------------------------.
    *@MethodName : setCookie
    *@author : 沐惜
    *@createTime : 2018/11/14 19:25
    *@description : 设置Cookie的值 不设置生效时间,但编码
    *@param :
     *@return :
    *@Version : 1.0
    *------------------------------
    */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, boolean isEncode) {
        setCookie(request, response, cookieName, cookieValue, -1, isEncode);
    }


    /**
    *------------------------------.
    *@MethodName : setCookie
    *@author : 沐惜
    *@createTime : 2018/11/14 19:25
    *@description : 设置Cookie的值 在指定时间内生效, 编码参数
    *@param :
     *@return :
    *@Version : 1.0
    *------------------------------
    */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, int cookieMaxage, boolean isEncode) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, isEncode);
    }


    /**
    *------------------------------.
    *@MethodName : setCookie
    *@author : 沐惜
    *@createTime : 2018/11/14 19:25
    *@description : 设置Cookie的值 在指定时间内生效, 编码参数(指定编码)
    *@param :
     *@return :
    *@Version : 1.0
    *------------------------------
    */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, int cookieMaxage, String encodeString) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, encodeString);
    }

    /**
    *------------------------------.
    *@MethodName : deleteCookie
    *@author : 沐惜
    *@createTime : 2018/11/14 19:25
    *@description : 删除Cookie带cookie域名
    *@param :
     *@return :
    *@Version : 1.0
    *------------------------------
    */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response,
            String cookieName) {
        doSetCookie(request, response, cookieName, "", -1, false);
    }


    /**
    *------------------------------.
    *@MethodName : doSetCookie
    *@author : 沐惜
    *@createTime : 2018/11/14 19:25
    *@description : 设置Cookie的值，并使其在指定时间内生效
    *@param : cookieMaxage cookie生效的最大秒数
     *@return :
    *@Version : 1.0
    *------------------------------
    */
    private static final void doSetCookie(HttpServletRequest request, HttpServletResponse response,
            String cookieName, String cookieValue, int cookieMaxage, boolean isEncode) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else if (isEncode) {
                cookieValue = URLEncoder.encode(cookieValue, "utf-8");
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0){
                cookie.setMaxAge(cookieMaxage);
            }
            if (null != request) {// 设置域名的cookie
            	String domainName = getDomainName(request);
            	System.out.println(domainName);
                if (!"localhost".equals(domainName)) {
                	cookie.setDomain(domainName);
                }
            }
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
        	 e.printStackTrace();
        }
    }


    /**
    *------------------------------.
    *@MethodName : doSetCookie
    *@author : 沐惜
    *@createTime : 2018/11/14 19:26
    *@description : 设置Cookie的值，并使其在指定时间内生效
    *@param : cookieMaxage cookie生效的最大秒数
     *@return :
    *@Version : 1.0
    *------------------------------
    */
    private static final void doSetCookie(HttpServletRequest request, HttpServletResponse response,
            String cookieName, String cookieValue, int cookieMaxage, String encodeString) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else {
                cookieValue = URLEncoder.encode(cookieValue, encodeString);
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0){
                cookie.setMaxAge(cookieMaxage);
            }
            if (null != request) {// 设置域名的cookie
            	String domainName = getDomainName(request);
            	System.out.println(domainName);
                if (!"localhost".equals(domainName)) {
                	cookie.setDomain(domainName);
                }
            }
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
        	 e.printStackTrace();
        }
    }


    /**
    *------------------------------.
    *@MethodName : getDomainName
    *@author : 沐惜
    *@createTime : 2018/11/14 19:26
    *@description : 得到cookie的域名
    *@param :
     *@return :
    *@Version : 1.0
    *------------------------------
    */
    private static final String getDomainName(HttpServletRequest request) {
        String domainName = null;

        String serverName = request.getRequestURL().toString();
        if (serverName == null || "".equals(serverName)) {
            domainName = "";
        } else {
            serverName = serverName.toLowerCase();
            serverName = serverName.substring(7);
            final int end = serverName.indexOf("/");
            serverName = serverName.substring(0, end);
            final String[] domains = serverName.split("\\.");
            int len = domains.length;
            if (len > 3) {
                // www.xxx.com.cn
                domainName = "." + domains[len - 3] + "." + domains[len - 2] + "." + domains[len - 1];
            } else if (len <= 3 && len > 1) {
                // xxx.com or xxx.cn
                domainName = "." + domains[len - 2] + "." + domains[len - 1];
            } else {
                domainName = serverName;
            }
        }

        if (domainName != null && domainName.indexOf(":") > 0) {
            String[] ary = domainName.split("\\:");
            domainName = ary[0];
        }
        return domainName;
    }

}

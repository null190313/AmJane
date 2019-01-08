package org.lxrookie.start.substance.interceptor;


import net.sf.json.JSONObject;
import org.lxrookie.cloud.annotations.ClientAnnotation;
import org.lxrookie.start.substance.constant.SysConfigConstant;
import org.lxrookie.start.substance.services.feignclient.EurekaLoginServicesClient;
import org.lxrookie.start.substance.services.obj.UserBaseProfessionalServices;
import org.lxrookie.start.substance.util.AESUtils;
import org.lxrookie.start.substance.util.CookieUtils;
import org.lxrookie.start.substance.util.JedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ------------------------------.
 *
 * @author : 沐惜
 * @name : GlobalInformationValidationInterceptor
 * @createTime : 2018/12/11 14:19
 * @description : 全局信息拦截验证,分发token及重定向统一认证
 * @Version : 1.0
 * ------------------------------
 */
public class GlobalInformationValidationInterceptor implements HandlerInterceptor {

    private static final Logger loogger = LoggerFactory.getLogger(GlobalInformationValidationInterceptor.class);
    @Autowired
    private UserBaseProfessionalServices userBaseProfessionalServices;
    @Autowired
    private EurekaLoginServicesClient eurekaLoginServicesClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器已启动");
        /**
         *  目前 仅实现客户端请求拦截 后续添加管理端拦截
         *  1.进行栏目功能判断  以注解形式判断  是否需要登录
         *  2.进行数据验证,是否存在用户数据
         *  3.存在  则不操作  不存在,则跳转统一认证
         *  request.getRequestURL() url全路径
         * */
        /**
         * 服务端 需要登录
         * */
        if (isClient(handler) && isLogin(handler)) {
            return checkDataValidity(request, response);
        }
        /**
         * 服务端 不需要登录
         * */
        if (isClient(handler) && !isLogin(handler)) {
            return true;
        }
        /**
         * 管理端
         * */
        if (!isClient(handler) && !isLogin(handler)) {
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        loogger.info("---------------------处理请求完成后视图渲染之前的处理操作----------------------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        loogger.info("---------------------视图渲染之后的操作----------------------------");
    }

    /**
     * ------------------------------.
     *
     * @name : isClient
     * @author : 沐惜
     * @createTime : 2018/12/11 17:34
     * @description : 判断服务端还是管理端  服务端 放回true   管理端 返回false
     * @Version : 1.0
     * ------------------------------
     */
    private boolean isClient(Object obj) {
        /**
         * 服务端or管理端
         * */
        String client = "";
        if (obj instanceof HandlerMethod) {
            ClientAnnotation clientAnnotation = ((HandlerMethod) obj).getMethod().getAnnotation(ClientAnnotation.class);
            if (null != clientAnnotation) {
                client = clientAnnotation.client();
                if ("CLIENT.PLA".equals(client)) {
                    return true;
                } else if ("SYSTEM.PLA".equals(client)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * ------------------------------.
     *
     * @name : isLogin
     * @author : 沐惜
     * @createTime : 2018/12/11 17:41
     * @description : 判断此url是否需要登录  需要登录 true  不需要false
     * @Version : 1.0
     * ------------------------------
     */
    private boolean isLogin(Object obj) {
        /**
         * 是否需要登陆
         * */
        String isLogin = "";
        if (obj instanceof HandlerMethod) {
            ClientAnnotation clientAnnotation = ((HandlerMethod) obj).getMethod().getAnnotation(ClientAnnotation.class);
            if (null != clientAnnotation) {
                isLogin = clientAnnotation.isLogin();
                if ("ALLOW.LO".equals(isLogin)) {
                    return true;
                } else if ("NOTALLOW.LO".equals(isLogin)) {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * ------------------------------.
     *
     * @name : checkUserInfoIsCorrect
     * @author : 沐惜
     * @createTime : 2018/12/11 18:16
     * @description : 判断用户cookieToken和cookieId是否正确
     * 验证成功返回true   失败返回false
     *              cookieId : 加密规则  用户ID + pwd AES加密
     *              cookieToken : cookieToken + cookieId AES 加密
     *              需完善cookieId 解密规则
     * @Version : 1.0
     * ------------------------------
     */
    private boolean checkUserInfoIsCorrect(String cookieToken, String cookieId) {
        if (null != cookieToken && null != cookieId) {
            String decryptionCookieToken = AESUtils.ecodes(cookieToken, cookieId);
            String redisUserBaseToken = JedisUtils.get(SysConfigConstant.USER_BASE_REDIS_COOKIEID + cookieId);
            String realCookieId = AESUtils.ecodes(cookieId, cookieId);
            if (redisUserBaseToken.equals(cookieId) && null != userBaseProfessionalServices.selectUserBaseProfessionalEntityByPrimaryKey(realCookieId)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * ------------------------------.
     *
     * @name : checkDataValidity
     * @author : 沐惜
     * @Param : request
     * @Param : response
     * @Return :
     * @createTime : 2018/12/13 9:43
     * @description : 检查当前用户的数据有效性
     * @Version : 1.0
     * ------------------------------
     */
    public boolean checkDataValidity(HttpServletRequest request, HttpServletResponse response) {
        String userBasetoken = CookieUtils.getCookieValue(request, SysConfigConstant.USER_BASE_COOKIENAME_TOKEN);
        String userBaseId = CookieUtils.getCookieValue(request, SysConfigConstant.USER_BASE_COOKIENAME_ID);

        if (null == userBasetoken || null == userBaseId) {
            redirectUnifiedAuthentication(request, response);
        } else {
            /**
             * 检查数据有效性  token  userId
             * */
            if (checkUserInfoIsCorrect(userBasetoken, userBaseId)) {
                return true;
            } else {
                redirectUnifiedAuthentication(request, response);
            }
        }
        return false;
    }

    /**
     * ------------------------------.
     *
     * @name : redirectUnifiedAuthentication
     * @author : 沐惜
     * @createTime : 2018/12/13 9:45
     * @description : 重定向到统一认证
     * @Version : 1.0
     * ------------------------------
     */
    public void redirectUnifiedAuthentication(HttpServletRequest request, HttpServletResponse response) {
        /**
         * 重定向到统一认证
         * */
        String stampState = String.valueOf(System.currentTimeMillis());
        String redirentId = SysConfigConstant.REDIRECT_CLIENT_ID;
        Map<String, String> map = new HashMap<String, String>();
        map.put("stampState", stampState);
        map.put("redirentId", redirentId);
        try {
            System.out.println(eurekaLoginServicesClient.achieveUnifiedAuthenticationURL(JSONObject.fromObject(map).toString()) + "重定向路径");
            response.sendRedirect(eurekaLoginServicesClient.achieveUnifiedAuthenticationURL(JSONObject.fromObject(map).toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package org.lxrookie.start.substance.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * ------------------------------.
 *
 * @author : 沐惜
 * @name : SessionUtils
 * @createTime : 2018/12/8 12:17
 * @description : Session基础操作
 * @Version : 1.0
 * ------------------------------
 */
public class SessionUtils {

    /**
     * ------------------------------.
     *
     * @name : SessionUtils
     * @author : 沐惜
     * @Param :  key 存储到session中的对象的变量名
     * @Param :  value 存储的任意数据
     * @createTime : 2018/12/8 12:19
     * @description : 把数据存储到session中
     * @Version : 1.0
     * ------------------------------
     */
    public static void push(String key, Object value) {
        HttpServletRequest request = request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().setAttribute(key, value);
    }

    /**
     * ------------------------------.
     *
     * @name : SessionUtils
     * @author : 沐惜
     * @Param : key 存储到session中的对象的变量名
     * @Return :  Object
     * @createTime : 2018/12/8 12:21
     * @description : 从session中获取数据
     * @Version : 1.0
     * ------------------------------
     */
    public static Object pop(String key) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession().getAttribute(key);
    }
    /**
     *------------------------------.
     * @name : SessionUtils
     * @author : 沐惜
     * @Param : key 存储到session中的对象的变量名
     * @Return :  boolean
     * @createTime : 2018/12/8 12:23
     * @description : 判断当前key对应的session值是否存在  存在返回true  不存在false
     * @Version : 1.0
     *------------------------------
     */
    public static boolean checkSessionExist(String key) {
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (null == request.getSession().getAttribute(key) || "".equals(request.getSession().getAttribute(key))) {
            return false;
        } else {
            return true;
        }
    }

}

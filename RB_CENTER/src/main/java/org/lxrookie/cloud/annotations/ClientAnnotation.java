package org.lxrookie.cloud.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *------------------------------.
 * @name : ClientDifferentiation
 * @author : 沐惜
 * @createTime : 2018/12/11 17:07
 * @description : 区分管理端还是用户端注解
 * @Version : 1.0
 *------------------------------
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClientAnnotation {

    /**
     * 服务端  CLIENT.PLA
     * 管理端  SYSTEM.PLA
     * */
    public String client() default "CLIENT.PLA";

    /**
     * 功能是否需要登录
     * ALLOW.LO 允许
     * NOTALLOW.LO 不允许
     * */
    public String isLogin() default "NOTALLOW.LO";


}

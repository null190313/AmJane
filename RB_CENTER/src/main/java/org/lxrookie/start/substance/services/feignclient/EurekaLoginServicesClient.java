package org.lxrookie.start.substance.services.feignclient;

import feign.Headers;
import org.lxrookie.start.substance.services.feignclient.hystrix.HystrixClientFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *------------------------------.
 * @name : EurekaLoginServicesClient
 * @author : 沐惜
 * @createTime : 2018/12/13 11:21
 * @description :  统一认证登录系统 EntryGlobal
 * @Version : 1.0
 *------------------------------
 */
@Component
@FeignClient(name = "EurekaEntryGlobalServer",
        url="www.rookieboy.cn:81/entryGlobal",
        fallback = HystrixClientFallbackFactory.class)
public interface EurekaLoginServicesClient {

    /**
     *------------------------------.
     * @name : EurekaLoginServicesClient
     * @author : 沐惜
     * @Param : jsonAuthentication{
     *     redirentId : ,
     *     stampState : ,
     * }需验证的两条信息
     * @Return :{
     *     state : ,
     *     url : ,
     * }
     * @createTime : 2018/12/13 11:38
     * @description : 获取统一认证url
     * @Version : 1.0
     *------------------------------
     */
    @PostMapping(value = "/achieveUnifiedAuthenticationURL.html")
    @Headers({"Content-Type: application/json","Accept: application/json"})
    public String achieveUnifiedAuthenticationURL(String jsonAuthentication);

}

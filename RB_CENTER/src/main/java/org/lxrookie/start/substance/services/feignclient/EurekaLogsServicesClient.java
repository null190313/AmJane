package org.lxrookie.start.substance.services.feignclient;

import feign.Headers;
import org.lxrookie.start.substance.services.feignclient.hystrix.HystrixClientFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 *------------------------------.
 * @name : EurekaLogsServices
 * @author : 沐惜
 * @createTime : 2018/12/1 15:38
 * @description : 日志系统服务(kafka)
 * @Version : 1.0
 *------------------------------
 */
@Component
@FeignClient(name = "EurekaLogsServer",
             url="http://localhost:8095",
             fallback = HystrixClientFallbackFactory.class)
public interface EurekaLogsServicesClient {
        /**
         *------------------------------.
         * @name : theUserLoginRecord
         * @author : 沐惜
         * @Param : JSONObject jsonObject
         * @Return : String (json字符串)
         * @createTime : 2018/12/1 16:56
         * @description : 通过feginCLient向kafka写日志
         * @Version : 1.0
         *------------------------------
         */
        @PostMapping(value = "/theUserLoginRecord.html")
        @Headers({"Content-Type: application/json","Accept: application/json"})
        public String theUserLoginRecord(@RequestParam(value = "logRecordEntity") String logRecordEntity);



        @RequestMapping(value = "/testCloudFeignClient.html/{testStr}",method = RequestMethod.GET)
        public String testCloudFeignClient(@PathVariable(name = "testStr") String testStr);
}

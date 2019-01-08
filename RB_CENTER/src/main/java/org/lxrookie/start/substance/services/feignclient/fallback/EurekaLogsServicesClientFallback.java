package org.lxrookie.start.substance.services.feignclient.fallback;

import org.lxrookie.start.substance.services.feignclient.EurekaLogsServicesClient;
import org.springframework.stereotype.Component;

/**
 *------------------------------.
 * @name : EurekaLogsServicesClientFallback
 * @author : 沐惜
 * @createTime : 2018/12/1 16:10
 * @description : TODO
 * @Version : 1.0
 *------------------------------
 */
@Component
public class EurekaLogsServicesClientFallback implements EurekaLogsServicesClient {
    @Override
    public String theUserLoginRecord(String logRecordEntity) {
        System.out.println("调用失败");
        return null;
    }

    @Override
    public String testCloudFeignClient(String testStr) {
        System.out.println("调用失败");
        return null;
    }
}

package org.lxrookie.start.substance.services.feignclient.hystrix;

import feign.hystrix.FallbackFactory;
import org.lxrookie.start.substance.services.feignclient.EurekaLogsServicesClient;
import org.lxrookie.start.substance.services.feignclient.hystrix.factory.EurekaLogsServicesClientWithFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<EurekaLogsServicesClient> {

    @Override
    public EurekaLogsServicesClient create(Throwable throwable) {
        return new EurekaLogsServicesClientWithFactory() {
            @Override
            public String theUserLoginRecord(String logRecordEntity) {
                return new String("fallback; reason was: " + throwable.getMessage());
            }

            @Override
            public String testCloudFeignClient(String testStr) {
                return new String("fallback; reason was: " + throwable.getMessage());
            }
        };
    }
}

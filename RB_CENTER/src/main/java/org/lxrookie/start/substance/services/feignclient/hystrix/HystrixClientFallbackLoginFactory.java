package org.lxrookie.start.substance.services.feignclient.hystrix;

import feign.hystrix.FallbackFactory;
import org.lxrookie.start.substance.services.feignclient.EurekaLoginServicesClient;

public class HystrixClientFallbackLoginFactory implements FallbackFactory<EurekaLoginServicesClient> {
    @Override
    public EurekaLoginServicesClient create(Throwable throwable) {
        return  new EurekaLoginServicesClient() {
            @Override
            public String achieveUnifiedAuthenticationURL(String jsonAuthentication) {
                return new String("fallback; reason was: " + throwable.getMessage());
            }
        };
    }
}

package org.lxrookie.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.lxrookie.start","org.lxrookie.cloud.configurer"})
public class CloudApplcation
{
    public static void main( String[] args )
    {
        SpringApplication.run(CloudApplcation.class, args);
    }
}

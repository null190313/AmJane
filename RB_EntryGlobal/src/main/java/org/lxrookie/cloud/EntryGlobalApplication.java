package org.lxrookie.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ImportResource(locations = "classpath*:load/loading.xml")
@MapperScan("org.lxrookie.start.substance.dao")
@EnableFeignClients(basePackages = "org.lxrookie.start.substance.services.feignclient")
@EnableEurekaClient
public class EntryGlobalApplication {

    public static void main( String[] args ) {
        SpringApplication.run(EntryGlobalApplication.class, args);
    }
}

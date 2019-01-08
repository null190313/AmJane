package org.lxrookie.cloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@ImportResource(locations = "classpath:load/loading.xml")
@MapperScan("org.lxrookie.start.substance.dao")
@EnableEurekaClient
public class LogsApplcation
{
    public static void main( String[] args )
    {
        SpringApplication.run(LogsApplcation.class, args);
    }
}

package org.lxrookie.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import tk.mybatis.spring.annotation.MapperScan;

/**
 *------------------------------.
 * @name : CenterApplication
 * @author : 沐惜
 * @createTime : 2018/12/6 15:08
 * @description : 模块启动类
 * @Version : 1.0
 *------------------------------
 */
@SpringBootApplication
@ImportResource(locations = "classpath*:load/loading.xml")
@MapperScan("org.lxrookie.start.substance.dao")
@EnableFeignClients(basePackages = "org.lxrookie.start.substance.services.feignclient")
public class CenterApplication
{
    public static void main( String[] args )
    {

        SpringApplication.run(CenterApplication.class, args);
    }
}

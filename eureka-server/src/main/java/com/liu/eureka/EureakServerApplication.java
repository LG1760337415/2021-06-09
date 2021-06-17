package com.liu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 飞翔天鸟
 * @version v1.0
 * @description: TODO
 * @date 2021/6/9 11:07
 */
@SpringBootApplication
@EnableEurekaServer
public class EureakServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EureakServerApplication.class,args);
    }
}

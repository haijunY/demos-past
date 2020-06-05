package com.haijuny.demo.demoeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer //声明一个注册中心
@SpringBootApplication
public class DemoEurekaserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaserverApplication.class, args);
    }

}

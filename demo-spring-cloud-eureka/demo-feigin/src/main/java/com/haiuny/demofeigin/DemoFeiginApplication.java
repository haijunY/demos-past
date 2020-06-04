package com.haiuny.demofeigin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients//开启feigin
@EnableDiscoveryClient//开启服务发现
@SpringBootApplication
public class DemoFeiginApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoFeiginApplication.class, args);
    }

}

package com.haijuny.demo.democonfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class DemoConfigClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoConfigClient2Application.class, args);
    }

}

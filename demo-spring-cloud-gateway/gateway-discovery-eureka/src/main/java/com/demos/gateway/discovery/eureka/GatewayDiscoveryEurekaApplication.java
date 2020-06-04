package com.demos.gateway.discovery.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GatewayDiscoveryEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayDiscoveryEurekaApplication.class, args);
    }

}

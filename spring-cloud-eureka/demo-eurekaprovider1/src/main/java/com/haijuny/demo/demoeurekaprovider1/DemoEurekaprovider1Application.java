package com.haijuny.demo.demoeurekaprovider1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DemoEurekaprovider1Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaprovider1Application.class, args);
    }

}

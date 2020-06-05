package com.haijuny.demo.demoribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix //开启断路器
@SpringBootApplication
public class DemoRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRibbonApplication.class, args);
    }

}

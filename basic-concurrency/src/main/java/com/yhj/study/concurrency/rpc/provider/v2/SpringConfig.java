package com.yhj.study.concurrency.rpc.provider.v2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @date: 2019/06/06 13:06
 */
@Configuration
@ComponentScan(basePackages = "com.yhj.study.concurrency.rpc.provider")
public class SpringConfig {

    @Bean(name = "gpRpcServer")
    public GpRpcServer getGpRpcServer(){
        return new GpRpcServer(8080);
    }
}

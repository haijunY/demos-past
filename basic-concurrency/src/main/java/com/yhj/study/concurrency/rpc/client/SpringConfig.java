package com.yhj.study.concurrency.rpc.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date: 2019/06/06 14:54
 */
@Configuration
public class SpringConfig {

    @Bean(name = "rpcProxyClient")
    public RpcProxyClient proxyClient(){
        return new RpcProxyClient();
    }

}

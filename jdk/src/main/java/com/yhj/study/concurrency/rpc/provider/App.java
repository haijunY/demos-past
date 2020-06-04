package com.yhj.study.concurrency.rpc.provider;

import com.yhj.study.concurrency.rpc.provider.v2.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @date: 2019/06/06 11:38
 */
public class App {

    public static void main(String[] args) {
//        IHelloService helloService = new HelloServiceImpl();
//        RpcProxyServer proxyServer = new RpcProxyServer();
//        proxyServer.publisher(8080, helloService);

        //用Spring管理
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        context.start();

    }

}

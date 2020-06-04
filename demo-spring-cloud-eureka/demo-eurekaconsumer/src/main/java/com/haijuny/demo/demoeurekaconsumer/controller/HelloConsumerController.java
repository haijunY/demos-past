package com.haijuny.demo.demoeurekaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloConsumerController {

    @Autowired
    LoadBalancerClient loadBalancerClient;//ribbon负载均衡器



    @GetMapping("/consumer")
    public String all() {
        // 发起REST请求
        return getUrl("eureka-provider");
    }

    /**
     * 获取指定url
     * @param clientApplicationName 指定的服务提供名
     * @return
     */
    private String getUrl(String clientApplicationName) {
        // 使用loadBalancerClient的choose函数来负载均衡的选出一个eurekaClient的服务实例
        ServiceInstance serviceInstance = loadBalancerClient.choose(clientApplicationName);
        // 获取之前eurekaClient /all接口地址
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort();
        System.out.println(url);
        //拼接服务访问URL
        String helloServiceUrl = url + "/hello/hello";

        return url;
    }

}

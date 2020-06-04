package com.haijuny.demo.demoribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author yinhaijun
 * @date: 2020/5/28
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hello(){
        String result = restTemplate.getForObject("http://eureka-provider/hello/hello/", String.class);
        return result;
    }
    public String hiError(){
        return "hiError";
    }

}

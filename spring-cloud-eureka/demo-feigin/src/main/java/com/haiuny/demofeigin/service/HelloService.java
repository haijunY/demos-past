package com.haiuny.demofeigin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.ScheduledExecutorService;

/**
 * @author yinhaijun
 * @date: 2020/5/28
 */
@FeignClient(value = "eureka-provider", fallback = SchedualServiceHiHystric.class)
public interface HelloService {
    @RequestMapping(value = "/hello/hello",method = RequestMethod.GET)
    String hello();
}

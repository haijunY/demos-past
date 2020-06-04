package com.haiuny.demofeigin.service;

import org.springframework.stereotype.Component;

/**
 * @author yinhaijun
 * @date: 2020/6/1
 */
@Component
public class SchedualServiceHiHystric implements HelloService {
    @Override
    public String hello() {
        return "hiError";
    }
}

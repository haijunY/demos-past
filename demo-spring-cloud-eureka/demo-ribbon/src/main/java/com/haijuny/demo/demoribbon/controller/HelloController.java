package com.haijuny.demo.demoribbon.controller;

import com.haijuny.demo.demoribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinhaijun
 * @date: 2020/5/28
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbon", method = RequestMethod.GET)
    public String hello(){
        String result = helloService.hello();
        return result;
    }

}

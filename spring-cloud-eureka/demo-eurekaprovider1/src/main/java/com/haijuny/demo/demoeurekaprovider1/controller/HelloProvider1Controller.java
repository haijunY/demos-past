package com.haijuny.demo.demoeurekaprovider1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "hello")
@RestController
public class HelloProvider1Controller {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        System.out.println("你好，我端口是1233");
        return "你好，我端口是1233";
    }

}

package com.haijuny.demo.demoeurekaprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "hello")
@RestController
public class HelloController {

    @RequestMapping(value = "hello")
    public String hello(){
        System.out.println("你好，我端口是1221");
        return "你好，我端口是1221";
    }

}

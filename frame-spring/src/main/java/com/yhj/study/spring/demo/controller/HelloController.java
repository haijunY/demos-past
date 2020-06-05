package com.yhj.study.spring.demo.controller;

import com.yhj.study.spring.demo.service.HelloService;
import com.yhj.study.spring.mvcframework.annotation.GPAutowired;
import com.yhj.study.spring.mvcframework.annotation.GPController;
import com.yhj.study.spring.mvcframework.annotation.GPRequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @date: 2019/05/15 11:35
 */
@GPController
@GPRequestMapping("/hello")
public class HelloController {

    @GPAutowired
    HelloService helloService;

    //返回String类型代表页面跳转
    @GPRequestMapping(value = "/ref")
    public String refHello(){
        System.out.println("HelloController...refHello...");
        return "hello";
    }

    //使用RequestParam注解直接获取值
    @GPRequestMapping(value = "/show")
    public void showHello(String name, HttpServletResponse resp) throws ServletException, IOException {
        helloService.showHello(name, resp);
    }

}
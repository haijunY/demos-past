package com.yhj.study.spring.demo.service.impl;

import com.yhj.study.spring.demo.service.HelloService;
import com.yhj.study.spring.mvcframework.annotation.GPService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @date: 2019/05/15 13:55
 */
@GPService
public class HelloServiceImpl implements HelloService {

    public void showHello(String name, HttpServletResponse resp) {
        System.out.println("ShowHelloServlet...doPost...");
        //获取值，并设置编码
        System.out.println("name=" + name);
        //输出，解决浏览器乱码问题
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try {
            resp.getWriter().write("我很好，你呢？");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("输出...");
    }

}

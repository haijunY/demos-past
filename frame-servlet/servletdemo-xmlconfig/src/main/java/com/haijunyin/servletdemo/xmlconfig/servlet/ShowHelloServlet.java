package com.haijunyin.servletdemo.xmlconfig.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowHelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ShowHelloServlet...doPost...");
        //获取值，并设置编码
        String name = new String(req.getParameter("name").getBytes("iso-8859-1"),"utf-8");//用request获取URL传递的中文参数,防止乱码
        System.out.println("name=" + name);
        //输出，解决浏览器乱码问题
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("我很好，你呢？");
        System.out.println("输出...");
    }

}

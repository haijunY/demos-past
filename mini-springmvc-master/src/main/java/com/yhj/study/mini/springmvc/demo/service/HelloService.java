package com.yhj.study.mini.springmvc.demo.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @date: 2019/05/15 13:54
 */
public interface HelloService {

    void showHello(String name, HttpServletResponse resp);

}

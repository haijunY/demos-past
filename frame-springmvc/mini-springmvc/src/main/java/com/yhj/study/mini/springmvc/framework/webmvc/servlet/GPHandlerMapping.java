package com.yhj.study.mini.springmvc.framework.webmvc.servlet;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @date: 2019/05/30 13:53
 */
@Data
public class GPHandlerMapping {

    private Object controller;  //保存方法对应的实例
    private Method method;      //保存映射方法
    private Pattern pattern;    //URL的正则匹配

    public GPHandlerMapping(Pattern pattern, Object controller, Method method) {
        this.pattern = pattern;
        this.controller = controller;
        this.method = method;
    }
}

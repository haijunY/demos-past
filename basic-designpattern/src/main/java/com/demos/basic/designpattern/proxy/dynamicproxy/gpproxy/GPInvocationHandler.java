package com.demos.basic.designpattern.proxy.dynamicproxy.gpproxy;

import java.lang.reflect.Method;

/**
 * Created by yhj on @date: 2019/05/08
 */
public interface GPInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            ;
}

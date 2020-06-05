package com.demos.basic.designpattern.proxy.dynamicproxy.jdkproxy;


import com.demos.basic.designpattern.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yhj on @date: 2019/05/08
 */
public class JDKMeipo implements InvocationHandler {

    private Person person;

    public Object getInstance(Person person)throws Exception{
        this.person = person;
        Class<?> clazz = person.getClass();
//        Person.class.getClassLoader();
        return Proxy.newProxyInstance(Person.class.getClassLoader(),clazz.getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.person, args);
        after();
        return obj;
    }

    //功能增强
    private void before(){
        System.out.println("我是媒婆，我要给你找对象");
        System.out.println("开始验货");
    }

    private void after(){
        System.out.println("OK");
    }



}

package com.yhj.study.designpattern.proxy.dynamicproxy.gpproxy;

import com.yhj.study.designpattern.proxy.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yhj on @date: 2019/05/08
 */
public class GPMeipo implements GPInvocationHandler {

    private Person person;

    public Object getInstance(Person person)throws Exception{
        this.person = person;
        Class<?> clazz = person.getClass();
        return GPProxy.newProxyInstance(new GPClassLoader(),clazz.getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        before();
        Object obj = null;
        try {
            obj = method.invoke(this.person, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
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

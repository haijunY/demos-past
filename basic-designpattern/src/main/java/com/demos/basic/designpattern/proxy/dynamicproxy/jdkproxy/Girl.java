package com.demos.basic.designpattern.proxy.dynamicproxy.jdkproxy;


import com.demos.basic.designpattern.proxy.Person;

/**
 * Created by yhj on @date: 2019/05/08
 */
public class Girl implements Person {
    @Override
    public void findLove() {
        System.out.println("高富帅");
        System.out.println("身高180cm");
        System.out.println("有6块腹肌");
    }

    @Override
    public void findHose() {
        System.out.println("找房子");
    }
}

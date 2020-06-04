package com.yhj.study.designpattern.proxy.staticproxy;


import com.yhj.study.designpattern.proxy.Person;

public class Son implements Person {

    public void findLove(){
        System.out.println("要求肤白貌美大长腿");
    }

    @Override
    public void findHose() {
        System.out.println("找房子");
    }

}

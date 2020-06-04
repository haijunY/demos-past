package com.yhj.study.designpattern.proxy.staticproxy;

import com.yhj.study.designpattern.proxy.dynamicproxy.jdkproxy.Girl;

/**
 * Created by yhj on @date: 2019/05/08
 */
public class FatherProxyTest {
    public static void main(String[] args) {
//        Father father = new Father(new Son());
        Father father = new Father(new Girl());

        father.findLove();
    }
}

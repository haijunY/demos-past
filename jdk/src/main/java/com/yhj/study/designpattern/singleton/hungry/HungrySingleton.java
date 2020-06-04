package com.yhj.study.designpattern.singleton.hungry;

/**
 * @date: 2019/05/06 15:22
 */
public class HungrySingleton {

    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }

}

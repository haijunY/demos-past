package com.demos.basic.designpattern.singleton.hungry;

/**
 * @date: 2019/05/06 15:24
 */
public class HungryStaticSingleton {
    private static final HungryStaticSingleton hungryStaticSingleton;

    static {
        hungryStaticSingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton(){

    }

    public static HungryStaticSingleton getInstance(){
        return hungryStaticSingleton;
    }
}

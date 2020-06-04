package com.yhj.study.designpattern.singleton.lazy;

/**
 * @date: 2019/05/06 15:26
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton lazy = null;

    private LazySimpleSingleton(){
    }

    public synchronized static LazySimpleSingleton getInstance(){
        if(lazy == null){
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }


}

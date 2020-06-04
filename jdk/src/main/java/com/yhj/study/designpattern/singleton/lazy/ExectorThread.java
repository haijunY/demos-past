package com.yhj.study.designpattern.singleton.lazy;

/**
 * @date: 2019/05/06 15:34
 */
public class ExectorThread implements Runnable {

    public void run() {

//        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();

        LazyDoubleCheckSingleton singleton = LazyDoubleCheckSingleton.getInstance();

        System.out.println(Thread.currentThread().getName()+":"+singleton);
    }
}

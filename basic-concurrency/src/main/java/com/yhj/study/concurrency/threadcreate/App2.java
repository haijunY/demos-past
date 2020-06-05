package com.yhj.study.concurrency.threadcreate;

/**
 * @date: 2019/05/09 16:30
 */
public class App2 extends Thread {

    @Override
    public void run(){
        super.run();
        System.out.println("App2被调用");
    }

}

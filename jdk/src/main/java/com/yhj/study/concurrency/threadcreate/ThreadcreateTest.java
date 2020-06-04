package com.yhj.study.concurrency.threadcreate;

import java.util.concurrent.*;

/**
 * @date: 2019/05/09 16:25
 */
public class ThreadcreateTest {

    public static void main(String[] args) {

        //实现Runnable接口
        App1 app = new App1();
        Thread thread1 = new Thread(app);
        thread1.start();
        //继承Thread
        Thread thread = new App2();
        thread.start();
        //callable
        App3 app3 = new App3();
        FutureTask f = new FutureTask(app3);
        new Thread(f).start();
        thread.interrupt();
    }

}

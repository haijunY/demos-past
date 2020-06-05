package com.yhj.study.concurrency.threadcreate;

/**
 * @date: 2019/06/05 11:43
 */
public class ThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("t1");
        });
        Thread t2 = new Thread(()->{
            System.out.println("t2");
        });
        Thread t3 = new Thread(()->{
            System.out.println("t3");
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();

    }

}

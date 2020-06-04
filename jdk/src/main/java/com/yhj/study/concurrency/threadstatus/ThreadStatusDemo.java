package com.yhj.study.concurrency.threadstatus;

import java.util.concurrent.TimeUnit;

/**
 * @date: 2019/05/10 9:11
 */
public class ThreadStatusDemo {


    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Time_Wating_Thread").start();

        new Thread(()->{
            while (true){
                synchronized (ThreadStatusDemo.class){
                    try {
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Wating_Thread").start();


        new Thread(new BlockedDemo(), "Blocked01_Thread").start();
        new Thread(new BlockedDemo(), "Blocked02_Thread").start();

    }


    static class BlockedDemo extends Thread{

        @Override
        public void run(){
            synchronized (BlockedDemo.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}

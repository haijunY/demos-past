package com.yhj.study.concurrency.synchronizedvolatile;

/**
 * @date: 2019/05/14 10:02
 */
public class VolatileDemo3 {

    public volatile static boolean stop = false ;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            int i = 0;
            while (!stop){
                i++;
//                System.out.println(i);
            }
        });
        t1.start();
//        Thread.sleep(1000);
        stop = true;
    }

}

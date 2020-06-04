package com.yhj.study.concurrency.synchronizedvolatile;

/**
 * @date: 2019/05/14 10:04
 */
public class VolatileDemo1 {

    private int flag = 0;

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo1 demo = new VolatileDemo1();
        for(int i=0; i<2000; i++){
            new Thread( ()-> demo.flag ++).start();
        }
        Thread.sleep(5000);
        System.out.println(demo.flag);
    }

}

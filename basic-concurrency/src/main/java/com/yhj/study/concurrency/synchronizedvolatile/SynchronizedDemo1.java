package com.yhj.study.concurrency.synchronizedvolatile;

import java.io.IOException;

/**
 * @date: 2019/05/14 11:15
 */
public class SynchronizedDemo1 {

//    static CountOb countOb = new CountOb();
//    public static void incr(){
//        synchronized (countOb) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            countOb.add();
//        }
//    }
//    public static void main(String[] args) throws IOException, InterruptedException {
//        for(int i=0;i<1000;i++){
//            new Thread(()->SynchronizedDemo1.incr()).start();
//        }
//        Thread.sleep(5000);
//        System.out.println("result:"+countOb.get());
//    }


    static Integer countOb = 0;
    public static void incr(){
        synchronized (countOb) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countOb = countOb + 1;
        }
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        for(int i=0;i<120;i++){
            new Thread(()->SynchronizedDemo1.incr()).start();
        }
        Thread.sleep(5000);
        System.out.println("result:"+countOb);
    }



}

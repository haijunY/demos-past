package com.yhj.study.concurrency.synchronizedvolatile;

/**
 * @date: 2019/05/14 9:52
 */
public class VolatileDemo2 {

    private static boolean stop = false;

//    public void m1(){
//        stop = false;
//        while (!stop){
//            System.out.println("执行业务");
//
//        }
//    }



    public static void main(String[] args) throws InterruptedException {
//        VolatileDemo2 demo = new VolatileDemo2();
        new Thread(()-> {
            stop = false;
            while (!stop){
                System.out.println("执行业务");

            }
        }).start();
//        new Thread(()-> demo.m2()).start();
        Thread.sleep(1000);
        stop = true;
//        demo.m2();
    }

}

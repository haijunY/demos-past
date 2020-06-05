package com.demos.basic.designpattern.singleton.lazy;

/**
 * @date: 2019/05/06 15:32
 */
public class LazySimpleSingletionTest {

    public static void main(String[] args) {
//        LazySimpleSingleton.getInstance();

        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());

        t1.start();
        t2.start();

        System.out.println("Extor End");

    }

}

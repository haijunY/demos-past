package com.yhj.study.jdk.basic;

/**
 * 一道经典面试题，考察return和finilly
 */
public class TryFinallyDemo {

    public static String f1(){
        String str = "hello";
        try{
            return str;
        }finally {
            str = "world";
        }
    }

    public static void main(String[] args) {
        String str = TryFinallyDemo.f1();
        System.out.println(str);
    }

}

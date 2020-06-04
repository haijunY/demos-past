package com.yhj.study.jdk.basic;

public class StringDemo {

    public static void main(String[] args) {
        String a = "123";//常量池（在堆中）存储"123"，变量a指向
        String b = "123";//因为常量池中有"123"了，b就会直接指向
        String c = new String("123");//new操作会在堆中创建一个新对象
        System.out.println(a==b);
        System.out.println(b==c);
    }
}

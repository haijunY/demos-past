package com.demos.basic.jdk.reflect;

/**
 * @author yinhaijun
 * @date: 2020/6/8
 */
public class ReflectTest1 {

    public static void main(String[] args) throws Exception {

        Class[] classes = new Class[0];
//        classes[0] = String.class;
//        classes[1] = ReflectTest1.class;
//        classes[2] = Long.class;
        new ReflectTest1().test1(classes);
    }


    public void test1(Class<?> ... classes){
        System.out.println(classes.length);
//        System.out.println(classes[0]);
//        System.out.println(classes[1]);
//        System.out.println(classes[2]);

    }

}

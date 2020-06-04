package com.yhj.study.jdk.basic;

import java.lang.reflect.Field;

/**
 * 实现swap()方法，使得a、b值互换
 * 考察点：反射、自动装箱、缓存范围
 */
public class IntegerDemo {

    public static void main(String[] args) throws Exception {
        Integer a = 1,b = 2;//Integer a = 1 相当于 Integer a = Integer.valueOf(1)
        System.out.println("before:a:" + a + "b:" + b);
        swap1(a, b);
        System.out.println("after:a:" + a + "b:" + b);
    }

    private static void swap1(Integer i1, Integer i2) throws Exception {
        //用反射拿到属性
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        //写法1
        int temp = i1.intValue();
        field.setInt(i1, i2.intValue());
        Integer t = Integer.valueOf(temp);//模拟装箱操作，这里t会变成2，因为在-128~127之前有缓存，装箱后值等于i1.value()=2
        field.setInt(i2, temp);//注意这里用的setInt，这样就避免了int类型的temp被自动装箱，不然装箱后temp传入的值是2

        //写法2
//        Integer temp = new Integer(i1.intValue());
//        field.set(i1, i2.intValue());
//        field.set(i2, temp);//temp是一个新对象，这样写
    }
}

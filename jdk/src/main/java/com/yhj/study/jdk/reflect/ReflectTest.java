package com.yhj.study.jdk.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) throws Exception {

        //获取Class对象方式
        System.out.println("======================= student.getClass()方式获取 =======================");
        Student student = new Student();
        Class<?> clazz1 = student.getClass();
        System.out.println(clazz1);
        System.out.println("======================= Student.class方式获取 ============================");
        Class<?> clazz2 = Student.class;
        System.out.println(clazz2);
        System.out.println("======================= Class.forName()方式获取 ==========================");
        Class<?> clazz3 = Class.forName("com.yhj.study.jdk.reflect.Student");
        System.out.println(clazz3);

        //获取Class构造器
        System.out.println("======================= 获取所有公有构造器 ==========================");
        Constructor<?>[] constructors1 =  clazz1.getConstructors();
        for(Constructor constructor : constructors1){
            System.out.println(constructor);
        }
        System.out.println("======================= 获取所有构造器 ==========================");
        Constructor<?>[] constructors2 = clazz1.getDeclaredConstructors();
        for(Constructor constructor : constructors2){
            System.out.println(constructor);
        }
        System.out.println("======================= 获取公有 & 无参构造器 ==========================");
        Constructor constructor1 = clazz1.getConstructor(null);
        System.out.println(constructor1);
        System.out.println("======================= 获取公有 & 有参构造器 ==========================");
        Constructor constructor2 = clazz1.getConstructor(String.class, int.class);
        System.out.println(constructor2);

        //获取Class字段
        System.out.println("======================= 获取所有公有字段 ==========================");
        Field[] fields1 = clazz1.getFields();
        for(Field field :fields1){
            System.out.println(field);
        }
        System.out.println("======================= 获取所有字段 ==========================");
        Field[] fields2 = clazz1.getDeclaredFields();
        for(Field field :fields2){
            System.out.println(field);
        }
        System.out.println("======================= 获取指定字段（公有） ==========================");
        Field nameField = clazz1.getField("name");
        System.out.println(nameField);
        System.out.println("======================= 获取指定字段（私有） ==========================");
        Field ageField = clazz1.getDeclaredField("age");
        System.out.println(ageField);

        System.out.println("======================= 获取一个公有构造器并实例化 =====================");
        Object obj = clazz1.getConstructor().newInstance();
        System.out.println(obj);
        System.out.println("======================= 给实例化对象直接赋值 =====================");
        nameField.set(obj, "张三");
        ageField.setAccessible(true);//强制访问
        ageField.set(obj, 18);
        System.out.println(obj);

        //获取Class方法
        System.out.println("======================= 获取所有公有方法 ==========================");
        Method[] methods1 = clazz1.getMethods();
        for(Method method : methods1){
            System.out.println(method);
        }
        System.out.println("======================= 获取所有方法 ==========================");
        Method[] methods2 = clazz1.getDeclaredMethods();
        for(Method method : methods2){
            System.out.println(method);
        }
        System.out.println("======================= 获取指定公有方法 ==========================");
        Method learningMethod1 = clazz1.getMethod("learning",String.class);
        System.out.println(learningMethod1);
        System.out.println("======================= 调用指定公有方法 ==========================");
        learningMethod1.invoke(obj, "反射知识");
        System.out.println("======================= 获取指定私有方法 ==========================");
        Method learningMethod2 = clazz1.getDeclaredMethod("think", String.class);
        learningMethod2.setAccessible(true);//强制访问
        Object ret = learningMethod2.invoke(obj, "如何攻克地心引力");
        System.out.println(ret);
    }

}

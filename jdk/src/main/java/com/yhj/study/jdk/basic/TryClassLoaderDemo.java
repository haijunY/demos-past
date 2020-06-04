package com.yhj.study.jdk.basic;

/**
 * 考察类加载器种类和关系
 */
public class TryClassLoaderDemo {

    public static void main(String[] args) {
        System.out.println(new TryClassLoaderDemo().getClass().getClassLoader().getParent().getParent());//BootstrapClassLoader
        System.out.println(new TryClassLoaderDemo().getClass().getClassLoader().getParent());//ExtClassLoader
        System.out.println(new TryClassLoaderDemo().getClass().getClassLoader());//AppCLassLoader

        //Object类是rt.jar包下的类，rt.jar包由BootstarpClassLoader加载，所以这里打印null
        System.out.println(new Object().getClass().getClassLoader());//BootstarpClassLoader

    }

}

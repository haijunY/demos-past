package com.yhj.study.jdk.jvm;

/**
 * GC日志演示
 * 需要在Run->EditConfigurations->VM options中配置-XX:+PrintGCDetails
 */
public class GCLogDemo {

    public static void main(String[] args) {
        int _1m = 1024 * 1024;
        byte[] data = new byte[_1m];
        // 将data置为null即让它成为垃圾
        data = null;
        // 通知垃圾回收器回收垃圾
        System.gc();
    }

}

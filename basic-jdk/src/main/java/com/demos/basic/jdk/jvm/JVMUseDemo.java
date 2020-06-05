package com.demos.basic.jdk.jvm;

/**
 * 查看JVM内存情况
 */
public class JVMUseDemo {

    public static void main(String[] args) {
        //最大
        long maxMemory = Runtime.getRuntime().maxMemory();
        //总
        long totalMemory = Runtime.getRuntime().totalMemory();
        //空闲
        long freeMemory = Runtime.getRuntime().freeMemory();
        //可用
        long usableMemory = maxMemory - totalMemory + freeMemory;
        System.out.println("最大：" + maxMemory);//单位是字节，1M=1024K，1K=1024byte
        System.out.println("总：" + totalMemory);
        System.out.println("空闲：" + freeMemory);
        System.out.println("可用：" + usableMemory);
        //
        System.out.println("dddd");

    }

}

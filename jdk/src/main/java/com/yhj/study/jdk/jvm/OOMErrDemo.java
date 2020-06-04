package com.yhj.study.jdk.jvm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OOMErrDemo {
    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private static Map<String, OOMErrDemo> map = new ConcurrentHashMap<>();
    public void submitTask() {
        for (int i = 0; i < 10; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "正处理");
                }
            });
        }
    }
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            OOMErrDemo ct1 = new OOMErrDemo();
            map.put("1", ct1);
            ct1.submitTask();
            map.remove("1");
        }
    }
}

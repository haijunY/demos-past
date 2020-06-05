package com.demos.basic.jdk.thread;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    static
    Executor executorSingle = Executors.newSingleThreadExecutor();//返回一个线程
    Executor executorFixed = Executors.newFixedThreadPool(4);//返回固定数量的线程池
    Executor executorCached = Executors.newCachedThreadPool();//不限制最大线程数量，线程空闲后会被回收
    Executor executorScheduled = Executors.newScheduledThreadPool(4);//延迟执行
//
    //自定义
    static Executor executor = new ThreadPoolExecutor(4,10,
                            10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new RejectedExecutionHandler() {
                                @Override
                                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                                    //拒绝处理
                                }
                            });

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("thread1");
        });
        executor.execute(thread);
    }


}

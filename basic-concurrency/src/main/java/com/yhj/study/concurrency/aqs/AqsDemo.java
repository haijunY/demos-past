package com.yhj.study.concurrency.aqs;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @date: 2019/05/15 10:17
 */
public class AqsDemo  {

    ReentrantLock lock = new ReentrantLock();

    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void m1(){
        lock.lock();
        System.out.println("执行方法m1");
        lock.unlock();
        //读写锁
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        Object obj  = new Object();
        readLock.lock();
        readLock.unlock();

        writeLock.lock();
        writeLock.unlock();
    }


    public static void main(String[] args) {
        AqsDemo aqsDemo = new AqsDemo();
        Thread t1 = new Thread(()->{
            aqsDemo.m1();
        });
        Thread t2 = new Thread(()->{
            aqsDemo.m1();
        });
        Thread t3 = new Thread(()->{
            aqsDemo.m1();
        });

        t1.start();
        t2.start();
        t3.start();
    }


}

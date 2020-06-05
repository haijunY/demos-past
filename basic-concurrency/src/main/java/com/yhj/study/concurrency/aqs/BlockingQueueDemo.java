package com.yhj.study.concurrency.aqs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @date: 2019/05/20 14:05
 */
public class BlockingQueueDemo {

    private int queueSize;       //最大可放置数
    private List<String> queue = new ArrayList<>();     //放置元素的队列
    Lock lock = new ReentrantLock();
    Condition conditionPut = lock.newCondition();
    Condition conditionTake = lock.newCondition();

    public BlockingQueueDemo(int queueSize){
        this.queueSize = queueSize;
    }

    private String generate(){
        return "123";
    }

    /** 当队列满了后，put会被阻塞，直到队列可以添加数据 */
    void put(){
        lock.lock();
        for(;;) {
            if (queue.size() < queueSize) {
                queue.add(generate());
                System.out.println("放入成功...个数：" + queue.size());
                conditionTake.signal();//唤醒take中的阻塞线程
                lock.unlock();
                return;
            } else {
                System.out.println("队列已满，无法放入元素，请等待...");
                try {
                    conditionPut.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** 队列为空时，take会被阻塞，直到队列不为空 */
    void take(){
        lock.lock();
        for(;;) {
            if (queue.size() > 0) {
                queue.remove(0);
                System.out.println("取出成功...个数：" + queue.size());
                conditionPut.signal();//唤醒put中的阻塞线程
                lock.unlock();
                return;
            } else {
                System.out.println("队列为空，无法取出元素，请等待...");
                try {
                    conditionTake.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        BlockingQueueDemo demo = new BlockingQueueDemo(5);
        //放入
        for(int i = 0; i<6; i++){
            Thread t1 = new Thread(()->{demo.put();});
            t1.start();
        }
        Thread.sleep(2000);
        //取出
        for(int i = 0; i<7; i++){
            Thread t1 = new Thread(()->{demo.take();});
            t1.start();
        }
        Thread.sleep(2000);
        //放入
        for(int i = 0; i<2; i++){
            Thread t1 = new Thread(()->{demo.put();});
            t1.start();
        }
        Thread.sleep(2000);
        System.out.println("最终元素个数：" + demo.queue.size());

    }

}

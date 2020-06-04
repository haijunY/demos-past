package com.yhj.study.concurrency.synchronizedvolatile;

/**
 * @date: 2019/05/13 16:59
 */
public class SynchronizedDemo implements Runnable{
    int x = 100;

    public synchronized void m1() {
//        System.out.println("执行m1");
        x = 1000;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("x=" + x);
//        System.out.println("执行m1结束");
    }

    public synchronized void m2() {
//        System.out.println("执行m2");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x = 2000;
//        System.out.println("执行m2结束");
    }
    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo sd = new SynchronizedDemo();
        new Thread(()->sd.m1()).start();//T1 R1
        new Thread(()->sd.m2()).start();//T2 R2
        sd.m2();//T3 R3
        System.out.println("Main x=" + sd.x);//R4
    }
    @Override
    public void run() {
        m1();
    }

    /**
     * 首先，这里同一个类中用了两个synchronized关键字，它们在对象sd的对象头中只会有一个锁内存分配，也就是说他们会相互阻塞
     *
     * x=1000
     * Main x=2000
     * 产生过程：R1(输出x=1000) -> R2 -> R3 -> R4(输出Main x=2000)
     * T1线程先抢到锁，赋值x=1000，然后进入睡眠TIME_WAITING，睡眠期间，T2和T3是被阻塞的，T1睡眠唤醒后，执行m1方法中的输出x=1000，接下来分别执行R2、R3，赋值后，执行输出Main x=2000，
     *
     *  Main x=2000
     * x=1000
     * 产生过程：R2 -> R3 -> R4(输出Main x=2000) -> R1(输出x=1000)
     * T2线程先抢到锁，赋值x=2000，然后T3抢到锁，也赋值x=2000，并且输出Main x=2000，最后T1抢到锁，赋值输出x=1000
     *
     * Main x=1000
     * x=1000
     * 产生过程：R3 -> R1(进入方法，赋值1000，睡眠中...) -> R4(输出Main x=1000) -> R1(睡醒了，输出x=1000) -> R2
     * T3线程先抢到锁，赋值x=2000，释放锁，在执行“Main x=“代码之前，锁被T1抢到了，赋值x=1000,T1进入睡眠，睡眠期间执行“Main x=“(因为这行代码并未被同步关键字包含)，输出Main x=1000，T1睡醒了，输出x=1000
     *
     */

}

package com.demos.basic.jdk.thread;

public class ThreadLocalDemo {

//    private static int num = 0;

//    static Index index = new Index();

//    private static ThreadLocal<Index> num = new ThreadLocal<Index>(){
//        protected Index initialValue(){
////            return index;
//            return new Index();
//        }
//    };

    private static ThreadLocal<Index> num = new ThreadLocal<Index>();

     static class Index{
        int num;
        public void incr(){
            num++;
        }
    }

    public static void main(String[] args) {
        num.set(new Index());
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
//                num+=5;
//                Integer localNum = num.get() + 5;
                num.set(new Index());
                Index index = num.get();
                index.incr();
                System.out.println(Thread.currentThread().getName()+"->"+num.get().num);
            },"thread"+i).start();
        }
        Index index = num.get();
        index.incr();
        System.out.println(Thread.currentThread().getName()+"->"+num.get().num);

    }

}

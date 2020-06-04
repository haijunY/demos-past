package com.yhj.study.designpattern.singleton.lazy;

/**
 * @date: 2019/05/06 15:55
 */
public class LazyDoubleCheckSingleton {
    private static LazyDoubleCheckSingleton lazy = null;

    private LazyDoubleCheckSingleton(){

    }

    //双重检查锁
    public static LazyDoubleCheckSingleton getInstance(){
        if(lazy == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if(lazy == null){
                    lazy = new LazyDoubleCheckSingleton();
                    //CPU执行时候会转换成JVM指令执行

                    //指令重排序问题，volatile关键字（解决通常CPU在执行第2和第3的时候没有顺序的问题）
                    //1、分配内存给这个对象
                    //2、初始化对象
                    //3、将初始化好的对象和内存地址建立关联，赋值
                    //4、用户初次访问

                }
            }
        }
        return lazy;
    }
}

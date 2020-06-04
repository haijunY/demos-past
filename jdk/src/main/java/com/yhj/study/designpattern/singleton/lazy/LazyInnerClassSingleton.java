package com.yhj.study.designpattern.singleton.lazy;

/**
 * @date: 2019/05/06 16:07
 */
//全程没有用synchronized
//性能最优的一种写法
//作业：理解内部类的执行逻辑
public class LazyInnerClassSingleton {


    //虽然构造方法私有了，但是逃不过反射的法眼
    private LazyInnerClassSingleton (){
        if(LazyHolder.LAZY != null){
            throw new RuntimeException("不允许构建多个实例");
        }
    }

    //懒汉式单例
    //LazyHolder 里面的逻辑需要等到外部调用时才执行
    //巧妙地运用了内部类的特性
    //JVM底层执行逻辑，完美地避免了线程安全问题
    public static  final LazyInnerClassSingleton getInstance(){
        return LazyHolder.LAZY;
    }

    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }

}

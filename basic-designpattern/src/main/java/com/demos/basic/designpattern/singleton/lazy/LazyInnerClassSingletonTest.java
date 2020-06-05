package com.demos.basic.designpattern.singleton.lazy;

import java.lang.reflect.Constructor;

/**
 * @date: 2019/05/06 17:06
 */
public class LazyInnerClassSingletonTest {

    public static void main(String[] args){
        try {
            //调用者装B，不走寻常路，显然，破坏了单例
            Class<?> clazz = LazyInnerClassSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            Object o1 = c.newInstance();
            Object o2 = LazyInnerClassSingleton.getInstance();
            System.out.println(o1==o2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

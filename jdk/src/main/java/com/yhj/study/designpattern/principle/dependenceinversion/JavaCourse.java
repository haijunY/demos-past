package com.yhj.study.designpattern.principle.dependenceinversion;

/**
 * @date: 2019/05/06 9:58
 */
public class JavaCourse implements ICourse {
    @Override
    public void study() {
        System.out.println("Tom在学习Java课程");
    }


}

package com.yhj.study.designpattern.factory;

/**
 * @date: 2019/05/06 14:30
 */
public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制Java课程");
    }
}

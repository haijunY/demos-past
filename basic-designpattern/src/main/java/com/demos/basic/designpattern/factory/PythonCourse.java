package com.demos.basic.designpattern.factory;

/**
 * @date: 2019/05/06 14:55
 */
public class PythonCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制Python课程");
    }
}

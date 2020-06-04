package com.yhj.study.designpattern.principle.dependenceinversion;

/**
 * @date: 2019/05/06 9:59
 */
public class PythonCourse implements ICourse {
    @Override
    public void study() {
        System.out.println("Tom在学习Python课程");
    }
}

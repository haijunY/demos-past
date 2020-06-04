package com.yhj.study.designpattern.factory.factorymethod;


import com.yhj.study.designpattern.factory.ICourse;

/**
 * @date: 2019/05/06 14:56
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        ICourseFactory factory = new JavaCourseFactory();
        ICourse course = factory.create();
        course.record();
    }
}

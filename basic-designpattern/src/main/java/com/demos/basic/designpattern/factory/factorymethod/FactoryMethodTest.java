package com.demos.basic.designpattern.factory.factorymethod;


import com.demos.basic.designpattern.factory.ICourse;

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

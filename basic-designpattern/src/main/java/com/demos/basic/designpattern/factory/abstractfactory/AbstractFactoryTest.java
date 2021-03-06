package com.demos.basic.designpattern.factory.abstractfactory;

import com.demos.basic.designpattern.factory.ICourse;

/**
 * @date: 2019/05/06 15:13
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        ICourseFactory factory = new JavaCourseFactory();
        ICourse course = factory.createCourse();
        course.record();
        INote note = factory.createNote();
        factory.createVideo();
    }
}

package com.demos.basic.designpattern.factory.factorymethod;


import com.demos.basic.designpattern.factory.ICourse;
import com.demos.basic.designpattern.factory.JavaCourse;

/**
 * @date: 2019/05/06 14:54
 */
public class JavaCourseFactory extends ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}

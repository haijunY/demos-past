package com.yhj.study.designpattern.factory.factorymethod;


import com.yhj.study.designpattern.factory.ICourse;
import com.yhj.study.designpattern.factory.JavaCourse;

/**
 * @date: 2019/05/06 14:54
 */
public class JavaCourseFactory extends ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}

package com.yhj.study.designpattern.factory.factorymethod;


import com.yhj.study.designpattern.factory.ICourse;
import com.yhj.study.designpattern.factory.PythonCourse;

/**
 * @date: 2019/05/06 14:55
 */
public class PythonCourseFactory extends ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}

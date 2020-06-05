package com.demos.basic.designpattern.factory.factorymethod;


import com.demos.basic.designpattern.factory.ICourse;
import com.demos.basic.designpattern.factory.PythonCourse;

/**
 * @date: 2019/05/06 14:55
 */
public class PythonCourseFactory extends ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}

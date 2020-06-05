package com.demos.basic.designpattern.factory.abstractfactory;


import com.demos.basic.designpattern.factory.ICourse;
import com.demos.basic.designpattern.factory.JavaCourse;

/**
 * @date: 2019/05/06 15:11
 */
public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse createCourse() {
        return new JavaCourse();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}

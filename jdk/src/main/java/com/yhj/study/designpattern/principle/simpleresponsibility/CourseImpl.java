package com.yhj.study.designpattern.principle.simpleresponsibility;

/**
 * @date: 2019/05/06 10:21
 */
public class CourseImpl implements ICourseInfo, ICourseManager {
    @Override
    public String getCourseName() {
        return null;
    }

    @Override
    public byte[] getCourseVideo() {
        return new byte[0];
    }

    @Override
    public void studyCourse() {

    }

    @Override
    public void refundCourse() {

    }
}

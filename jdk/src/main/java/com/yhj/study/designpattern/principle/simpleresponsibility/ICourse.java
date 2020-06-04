package com.yhj.study.designpattern.principle.simpleresponsibility;

/**
 * @date: 2019/05/06 10:16
 */
public interface ICourse {

    //展示职责
    //获得基本信息
    String getCourseName();
    //获得视频流
    byte[] getCourseVideo();

    //管理职责
    //学习课程
    void studyCourse();
    //退款
    void refundCourse();

}

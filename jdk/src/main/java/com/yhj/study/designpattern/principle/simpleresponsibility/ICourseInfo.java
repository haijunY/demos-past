package com.yhj.study.designpattern.principle.simpleresponsibility;

/**
 * @date: 2019/05/06 10:19
 */
public interface ICourseInfo {

    //展示职责
    //获得基本信息
    String getCourseName();
    //获得视频流
    byte[] getCourseVideo();

}

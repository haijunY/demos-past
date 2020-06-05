package com.demos.basic.designpattern.principle.simpleresponsibility;

/**
 * @date: 2019/05/06 10:07
 */
public class Course {

    public void study(String courseName){
        if("直播课".equals(courseName)){
            System.out.println(courseName + "不能快进");
        }else {
            System.out.println(courseName + "可以反复回看");
        }

    }

//    public static void main(String[] args) {
//        Course course = new Course();
//        course.study("直播课");
//        course.study("录播课");
//    }

    public static void main(String[] args) {
        LiveCourse liveCourse = new LiveCourse();
        liveCourse.study("直播课");
        ReplayCourse replayCourse = new ReplayCourse();
        replayCourse.study("录播课");
    }

}

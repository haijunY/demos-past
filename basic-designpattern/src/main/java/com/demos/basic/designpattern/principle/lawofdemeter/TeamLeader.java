package com.demos.basic.designpattern.principle.lawofdemeter;

import java.util.List;

/**
 * @date: 2019/05/06 10:32
 */
public class TeamLeader {

    public void checkNumberOfCourses(List<Course> courseList){
        System.out.println("目前已发布的课程数量是："+courseList.size());
    }

}

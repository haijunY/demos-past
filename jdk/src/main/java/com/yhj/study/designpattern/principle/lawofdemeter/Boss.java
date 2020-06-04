package com.yhj.study.designpattern.principle.lawofdemeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2019/05/06 10:34
 */
public class Boss {

    public void commandCheckNumber(TeamLeader teamLeader){
        List<Course> courseList = new ArrayList<>();
        for(int i = 0; i < 20 ; i++){
            courseList.add(new Course());
        }
        teamLeader.checkNumberOfCourses(courseList);
    }

    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.commandCheckNumber(new TeamLeader());
    }

}

package com.yhj.study.designpattern.principle.dependenceinversion;

/**
 * @date: 2019/05/06 9:53
 */
public class Tom {

//    public void studyJavaCourse(){
//        System.out.println("Tom在学习Java课程");
//    }
//
//    public void studyPythonCourse(){
//        System.out.println("Tom在学习Python课程");
//    }

    public void study(ICourse course){
        course.study();
    }


    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.study(new JavaCourse());
        tom.study(new PythonCourse());

    }

}

package com.demos.basic.designpattern.factory.simplefactory;


import com.demos.basic.designpattern.factory.ICourse;
import com.demos.basic.designpattern.factory.JavaCourse;

/**
 * @date: 2019/05/06 14:29
 */
public class SimplefactoryTest {

//    public static void main(String[] args) {
//        ICourse javaCourse = new JavaCourse();
//        javaCourse.record();
//    }

//    public static void main(String[] args) {
//        CourseFactory factory = new CourseFactory();
//        ICourse course = factory.create("com.gp.factory.simplefactory.JavaCourse");
//        course.record();
//    }

    public static void main(String[] args) {
        CourseFactory factory = new CourseFactory();
        ICourse course = factory.create(JavaCourse.class);
        course.record();
    }

}

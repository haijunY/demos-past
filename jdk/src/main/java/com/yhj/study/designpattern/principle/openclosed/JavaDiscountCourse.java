package com.yhj.study.designpattern.principle.openclosed;

/**
 * @date: 2019/05/06 9:45
 */
public class JavaDiscountCourse extends JavaCourse {

    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getOriginPrice() {
        return super.getPrice();
    }

//    public Double getPrice(){
//        return super.getPrice() * 0.61;
//    }

    //里氏替换原则
    public Double getDiscountPrice(){
        return super.getPrice() * 0.61;
    }

}

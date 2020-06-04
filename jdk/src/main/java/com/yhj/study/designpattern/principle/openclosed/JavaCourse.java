package com.yhj.study.designpattern.principle.openclosed;

/**
 * @date: 2019/05/06 9:40
 */
public class JavaCourse implements ICourse {

    private Integer id;

    private String name;

    private Double price;

    public JavaCourse(Integer id, String name, Double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}

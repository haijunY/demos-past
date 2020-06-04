package com.yhj.study.designpattern.principle.liskowsubstitution;

/**
 * @date: 2019/05/06 10:47
 */
public class Rectangle implements Quadrangle {

    @Override
    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }
    @Override
    public long getWidth() {
        return width;
    }

    public void setWidth(long width) {
        this.width = width;
    }

    private long height;
    private long width;




}

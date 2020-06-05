package com.demos.basic.designpattern.factory.abstractfactory;


import com.demos.basic.designpattern.factory.ICourse;

/**
 * @date: 2019/05/06 15:05
 */
//一个品牌的抽象
public interface ICourseFactory {
    ICourse createCourse();
    INote createNote();
    IVideo createVideo();
}

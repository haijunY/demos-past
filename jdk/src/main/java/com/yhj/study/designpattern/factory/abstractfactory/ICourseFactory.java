package com.yhj.study.designpattern.factory.abstractfactory;

import com.yhj.study.designpattern.factory.ICourse;

/**
 * @date: 2019/05/06 15:05
 */
//一个品牌的抽象
public interface ICourseFactory {
    ICourse createCourse();
    INote createNote();
    IVideo createVideo();
}

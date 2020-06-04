package com.yhj.study.designpattern.factory.factorymethod;

import com.yhj.study.designpattern.factory.ICourse;

/**
 * @date: 2019/05/06 14:52
 */
public abstract class ICourseFactory {

    public void pre(){
        //公共处理
    }

    abstract ICourse create();

}

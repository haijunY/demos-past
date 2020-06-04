package com.yhj.study.mini.springmvc.framework.context.support;

import com.yhj.study.mini.springmvc.framework.context.GPApplicationContext;

/**
 * 通过解耦的方式活动IOC容器的顶层设计
 * 后面将通过一个监听器去扫描所有的类，只要实现了此接口
 * 将自动调用setApplicationContext()从而将IOC容器注入到目标类中
 * @date: 2019/05/28 14:12
 */
public interface GPApplicationContextAware {

    void setApplicationContext(GPApplicationContext applicationContext);

}

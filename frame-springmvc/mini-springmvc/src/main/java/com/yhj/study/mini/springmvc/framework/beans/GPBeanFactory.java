package com.yhj.study.mini.springmvc.framework.beans;

/**
 * 单例工厂的顶层设计
 * @date: 2019/05/28 12:57
 */
public interface GPBeanFactory {

    /**
     * 根据beanName从IOC容器中获得一个实例的Bean
     * @param beanName
     * @return
     */
    Object getBean(String beanName) throws Exception;

}

package com.yhj.study.mini.springmvc.framework.beans.support;

import com.yhj.study.mini.springmvc.framework.beans.config.GPBeanDefinition;
import com.yhj.study.mini.springmvc.framework.context.support.GPAbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @date: 2019/05/28 13:12
 */
public class GPDefaultListableBeanFactory extends GPAbstractApplicationContext {

    /** Map of singleton-only bean names, keyed by dependency type */
    public final Map<String, GPBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, GPBeanDefinition>(256);

}

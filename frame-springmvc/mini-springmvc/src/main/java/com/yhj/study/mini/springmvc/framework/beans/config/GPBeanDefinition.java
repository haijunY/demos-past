package com.yhj.study.mini.springmvc.framework.beans.config;

import lombok.Data;

/**
 * @date: 2019/05/28 13:59
 */
@Data
public class GPBeanDefinition {

    private String beanClassName;
    private boolean lazyInit = false;
    private String factoryBeanName;
    private boolean singleton = true;
}

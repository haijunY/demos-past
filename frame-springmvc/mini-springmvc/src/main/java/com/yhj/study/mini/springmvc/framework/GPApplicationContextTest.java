package com.yhj.study.mini.springmvc.framework;

import com.yhj.study.mini.springmvc.framework.context.GPApplicationContext;

/**
 * @date: 2019/05/30 10:06
 */
public class GPApplicationContextTest {

    public static void main(String[] args) {
        GPApplicationContext applicationContext = new GPApplicationContext("application.properties");
        applicationContext.refresh();
    }

}

package com.yhj.study.mini.springmvc.framework.annotation;

import java.lang.annotation.*;

/**
 * @date: 2019/05/15 14:00
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPRequestMapping {
    String value() default "";
}

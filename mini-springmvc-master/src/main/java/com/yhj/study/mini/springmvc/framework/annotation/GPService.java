package com.yhj.study.mini.springmvc.framework.annotation;

import java.lang.annotation.*;

/**
 * @date: 2019/05/15 14:01
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPService {
    String value() default "";
}

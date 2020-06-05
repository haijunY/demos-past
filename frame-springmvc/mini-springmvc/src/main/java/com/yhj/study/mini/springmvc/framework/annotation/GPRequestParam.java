package com.yhj.study.mini.springmvc.framework.annotation;

import java.lang.annotation.*;

/**
 * @date: 2019/05/30 16:13
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPRequestParam {
    String value() default "";

}

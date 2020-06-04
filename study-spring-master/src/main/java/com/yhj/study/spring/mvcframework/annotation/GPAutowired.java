package com.yhj.study.spring.mvcframework.annotation;

import java.lang.annotation.*;

/**
 * @date: 2019/05/15 11:55
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GPAutowired {
    String value() default "";
}

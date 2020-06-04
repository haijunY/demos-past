package com.yhj.study.concurrency.rpc.provider.v2;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component      //交给spring扫描
public @interface RpcService {

    Class<?> value();//拿到服务的接口

    //版本号
    String version() default  "";

}

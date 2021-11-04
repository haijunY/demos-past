package com.yhj.study.spring.event.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author yinhaijun
 * @description:
 * @date 2021/9/28 14:52
 */
public class OrderSuccessEvent extends ApplicationEvent {
    public OrderSuccessEvent(Object source) {
        super(source);
    }
}

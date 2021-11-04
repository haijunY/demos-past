package com.yhj.study.spring.event.service;

import com.yhj.study.spring.event.event.OrderSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author yinhaijun
 * @description:
 * @date 2021/9/28 15:26
 */
@Service
public class AnnotationSmsService{

    /**
     * 发送短信
     */
    @EventListener(OrderSuccessEvent.class)
    public void sendSms() {
        System.out.println("发送短信（注解方式）...");
    }
}

package com.yhj.study.spring.event.service;

import com.yhj.study.spring.event.event.OrderSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @author yinhaijun
 * @description:
 * @date 2021/9/28 14:53
 */
@Service
public class SmsService implements ApplicationListener<OrderSuccessEvent> {
    @Override
    public void onApplicationEvent(OrderSuccessEvent orderSuccessEvent) {
        this.sendSms();
    }

    /**
     * 发送短信
     */
    public void sendSms() {
        System.out.println("发送短信...");
    }
}

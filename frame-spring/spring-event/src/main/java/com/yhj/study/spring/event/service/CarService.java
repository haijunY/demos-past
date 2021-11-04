package com.yhj.study.spring.event.service;

import com.yhj.study.spring.event.event.OrderSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @author yinhaijun
 * @description:
 * @date 2021/9/28 15:24
 */
@Service
public class CarService implements ApplicationListener<OrderSuccessEvent> {
    @Override
    public void onApplicationEvent(OrderSuccessEvent orderSuccessEvent) {
        this.sendCar();
    }

    /**
     * 发车
     */
    public void sendCar() {
        System.out.println("发车咯...");
    }
}

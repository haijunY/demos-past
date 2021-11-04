package com.yhj.study.spring.event.service;

import com.yhj.study.spring.event.event.OrderSuccessEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yinhaijun
 * @description:
 * @date 2021/9/28 14:50
 */
@Service
public class OrderService {

    @Autowired
    private ApplicationContext applicationContext;

    @Transactional
    public void order(){
        System.out.println("下单成功");
        // 发布通知，这样是同步执行
        applicationContext.publishEvent(new OrderSuccessEvent(this));
        System.out.println("main线程结束");
    }

}

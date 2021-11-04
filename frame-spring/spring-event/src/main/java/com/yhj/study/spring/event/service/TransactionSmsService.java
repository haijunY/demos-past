package com.yhj.study.spring.event.service;

import com.yhj.study.spring.event.event.OrderSuccessEvent;
import org.springframework.stereotype.Component;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author yinhaijun
 * @description:
 * @date 2021/9/28 16:06
 */
@Component
public class TransactionSmsService {

    @TransactionalEventListener
    public void hanldeOrderCreatedEvent(OrderSuccessEvent event) {
        this.sendSms();
    }

    public void sendSms() {
        System.out.println("发送短信（事务提交后）...");
    }

}

package com.yhj.study.spring.event.test;

import com.yhj.study.spring.event.service.OrderService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yinhaijun
 * @description:
 * @date 2021/9/28 15:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    private OrderService orderService;

    @org.junit.Test
    public void testSpringEvent() {
        orderService.order();
    }
}

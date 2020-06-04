package com.yhj.study.designpattern.proxy.dbroute;


import com.yhj.study.designpattern.proxy.dbroute.proxy.OrderServiceDynamicProxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yhj on @date: 2019/05/08
 */
public class DbRouteProxyTest {
    public static void main(String[] args) throws ParseException {
        Order order = new Order();
//        order.setCreateTime(new Date().getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = format.parse("2017/02/02");
        order.setCreateTime(date.getTime());
        //静态代理
//        IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
        //动态代理
        IOrderService orderService = (IOrderService) new OrderServiceDynamicProxy().getInstance(new OrderService());
//        orderService.createOrder(order);
        orderService.queryOrder(order);
    }
}

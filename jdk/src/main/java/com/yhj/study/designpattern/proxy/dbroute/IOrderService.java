package com.yhj.study.designpattern.proxy.dbroute;

public interface IOrderService {

    int createOrder(Order order);
    Order queryOrder(Order order);
}

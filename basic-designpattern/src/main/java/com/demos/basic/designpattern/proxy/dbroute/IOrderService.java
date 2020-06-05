package com.demos.basic.designpattern.proxy.dbroute;

public interface IOrderService {

    int createOrder(Order order);
    Order queryOrder(Order order);
}

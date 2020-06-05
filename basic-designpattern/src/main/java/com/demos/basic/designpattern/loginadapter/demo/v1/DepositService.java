package com.demos.basic.designpattern.loginadapter.demo.v1;

import com.demos.basic.designpattern.loginadapter.demo.v1.dto.Order;
import com.demos.basic.designpattern.loginadapter.demo.v1.dto.ResultMsg;

public interface DepositService {

    //兼容方法
    ResultMsg createOrder(Order order);

    //不兼容方法，以后可能会慢慢淘汰的方法
    ResultMsg pay(String orderId);

    //...有多个...这样的方法

}

package com.demos.basic.designpattern.loginadapter.demo.v1.impl;

import com.demos.basic.designpattern.loginadapter.demo.v1.DepositService;
import com.demos.basic.designpattern.loginadapter.demo.v1.dto.Order;
import com.demos.basic.designpattern.loginadapter.demo.v1.dto.ResultMsg;

public class DepositServiceImpl implements DepositService {

    @Override
    public ResultMsg createOrder(Order order) {
        return null;
    }

    @Override
    public ResultMsg pay(String orderId) {
        ResultMsg msg = new ResultMsg();
        msg.setMsg("成功支付");
        return msg;
    }
}

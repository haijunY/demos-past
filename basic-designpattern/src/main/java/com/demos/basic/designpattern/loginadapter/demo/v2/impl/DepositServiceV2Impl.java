package com.demos.basic.designpattern.loginadapter.demo.v2.impl;

import com.demos.basic.designpattern.loginadapter.demo.v1.dto.Order;
import com.demos.basic.designpattern.loginadapter.demo.v1.dto.ResultMsg;
import com.demos.basic.designpattern.loginadapter.demo.v1.impl.DepositServiceImpl;
import com.demos.basic.designpattern.loginadapter.demo.v2.DepositServiceV2;
import com.demos.basic.designpattern.loginadapter.demo.v2.adapters.PayForQQAdapter;

public class DepositServiceV2Impl extends DepositServiceImpl implements DepositServiceV2 {

    @Override
    public ResultMsg createOrder(Order order) {
        return super.createOrder(order);
    }

    @Override
    public ResultMsg payForQQ(String orderId, PayForQQAdapter.PayInfoForQQ payInfo) {
        PayForQQAdapter adapter = new PayForQQAdapter();
        if(adapter.support(payInfo)){
            return adapter.pay(orderId, payInfo);
        }
        return null;
    }

}

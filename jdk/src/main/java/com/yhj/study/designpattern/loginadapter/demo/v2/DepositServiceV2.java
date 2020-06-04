package com.yhj.study.designpattern.loginadapter.demo.v2;

import com.yhj.study.designpattern.adapter.loginadapter.demo.v1.dto.Order;
import com.yhj.study.designpattern.adapter.loginadapter.demo.v1.dto.ResultMsg;
import com.yhj.study.designpattern.adapter.loginadapter.demo.v2.adapters.PayForQQAdapter;

public interface DepositServiceV2 {

    ResultMsg createOrder(Order order);

    ResultMsg payForQQ(String orderId, PayForQQAdapter.PayInfoForQQ payInfo);


}

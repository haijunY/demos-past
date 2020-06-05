package com.demos.basic.designpattern.loginadapter.demo.v2;

import com.demos.basic.designpattern.loginadapter.demo.v1.dto.Order;
import com.demos.basic.designpattern.loginadapter.demo.v1.dto.ResultMsg;
import com.demos.basic.designpattern.loginadapter.demo.v2.adapters.PayForQQAdapter;

public interface DepositServiceV2 {

    ResultMsg createOrder(Order order);

    ResultMsg payForQQ(String orderId, PayForQQAdapter.PayInfoForQQ payInfo);


}

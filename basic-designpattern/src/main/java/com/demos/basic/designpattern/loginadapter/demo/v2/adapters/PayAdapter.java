package com.demos.basic.designpattern.loginadapter.demo.v2.adapters;

import com.demos.basic.designpattern.loginadapter.demo.v1.dto.ResultMsg;

public interface PayAdapter {

    boolean support(Object adapter);

    ResultMsg pay(String orderId, Object adapter);


}

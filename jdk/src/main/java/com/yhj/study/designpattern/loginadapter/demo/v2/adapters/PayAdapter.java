package com.yhj.study.designpattern.loginadapter.demo.v2.adapters;

import com.yhj.study.designpattern.adapter.loginadapter.demo.v1.dto.ResultMsg;

public interface PayAdapter {

    boolean support(Object adapter);

    ResultMsg pay(String orderId, Object adapter);


}

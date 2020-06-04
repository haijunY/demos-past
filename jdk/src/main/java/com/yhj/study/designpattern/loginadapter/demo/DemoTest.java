package com.yhj.study.designpattern.loginadapter.demo;

import com.yhj.study.designpattern.adapter.loginadapter.demo.v1.DepositService;
import com.yhj.study.designpattern.adapter.loginadapter.demo.v1.dto.Order;
import com.yhj.study.designpattern.adapter.loginadapter.demo.v1.dto.ResultMsg;
import com.yhj.study.designpattern.adapter.loginadapter.demo.v1.impl.DepositServiceImpl;
import com.yhj.study.designpattern.adapter.loginadapter.demo.v2.DepositServiceV2;
import com.yhj.study.designpattern.adapter.loginadapter.demo.v2.adapters.PayForQQAdapter;
import com.yhj.study.designpattern.adapter.loginadapter.demo.v2.impl.DepositServiceV2Impl;

public class DemoTest {

    public static void main(String[] args) {
        DepositService depositServiceV1 = new DepositServiceImpl();
        depositServiceV1.createOrder(new Order());
        ResultMsg msgv1 = depositServiceV1.pay("orderId");
        System.out.println(msgv1);

        //重构系统的时候，可以先做出V2版本的接口，与外部系统对接，时间长了后删除V1版本
        //这样做的好处是可以逐渐去重构代码，因为接口中有多个方法，不可能一次性全部成功重构，出BUG几率很大
        //我们可以通过一个一个的适配器方式去迭代，暂时没有重构的方法可以把support方法返回false，
        // 或将继承下来的方法调用父类方法super.createOrder(order);
        DepositServiceV2 depositServiceV2 = new DepositServiceV2Impl();
        depositServiceV2.createOrder(new Order());
        PayForQQAdapter.PayInfoForQQ payInfoFor = new PayForQQAdapter.PayInfoForQQ();
        payInfoFor.setQqNo("24242444");
        ResultMsg msgv2 =depositServiceV2.payForQQ("orderId",payInfoFor);
        System.out.println(msgv2);

    }

}

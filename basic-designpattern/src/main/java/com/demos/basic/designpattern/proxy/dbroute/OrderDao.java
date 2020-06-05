package com.demos.basic.designpattern.proxy.dbroute;

/**
 * Created by yhj on @date: 2019/05/08
 */
public class OrderDao {

    public int insert(Order order){
        System.out.println("OrderDao创建Order成功");
        return 1;
    }

    public Order query(Order order){
        System.out.println("OrderDao查询Order成功");
        order.setId("1");
        return order;
    }
}

package com.demos.basic.designpattern.proxy.dbroute.proxy;

import com.demos.basic.designpattern.proxy.dbroute.IOrderService;
import com.demos.basic.designpattern.proxy.dbroute.Order;
import com.demos.basic.designpattern.proxy.dbroute.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yhj on @date: 2019/05/08
 */
public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService){
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
        DynamicDataSourceEntity.set(dbRouter);
        this.orderService.createOrder(order);
        DynamicDataSourceEntity.restore();
        return 0;
    }

    @Override
    public Order queryOrder(Order order) {
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】数据源处理数据");
        DynamicDataSourceEntity.set(dbRouter);
        order = this.orderService.queryOrder(order);
        DynamicDataSourceEntity.restore();
        return order;
    }
}

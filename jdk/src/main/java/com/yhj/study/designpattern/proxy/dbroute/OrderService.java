package com.yhj.study.designpattern.proxy.dbroute;

/**
 * Created by yhj on @date: 2019/05/08
 */
public class OrderService implements IOrderService {
    private OrderDao orderDao;
    public OrderService(){
        //如果使用Spring应该是自动注入的
        //我们为了使用方便，在构造方法中将OrderDao初始化了
        orderDao = new OrderDao();
    }
    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService调用orderDao创建订单");
        return orderDao.insert(order);
    }

    @Override
    public Order queryOrder(Order order) {
        System.out.println("OrderService调用orderDao查询订单");
        return orderDao.query(order);
    }
}

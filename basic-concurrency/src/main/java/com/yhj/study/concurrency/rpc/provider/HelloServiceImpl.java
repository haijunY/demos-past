package com.yhj.study.concurrency.rpc.provider;

import com.yhj.study.concurrency.rpc.IHelloService;
import com.yhj.study.concurrency.rpc.provider.v2.RpcService;
import com.yhj.study.concurrency.work.d190508.User;

/**
 * @date: 2019/06/06 11:06
 */
@RpcService(value = IHelloService.class, version = "1.0")
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String content) {
        System.out.println("【v1.0】request in :" + content);
        return "【v1.0】Say hello: " + content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("【v1.0】request in saveUser: " + user);
        return "【v1.0】SUCCESS";
    }

}

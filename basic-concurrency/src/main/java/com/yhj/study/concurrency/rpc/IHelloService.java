package com.yhj.study.concurrency.rpc;

import com.yhj.study.concurrency.work.d190508.User;

/**
 * @date: 2019/06/06 11:02
 */
public interface IHelloService {

    String sayHello(String content);

    String saveUser(User user);

}

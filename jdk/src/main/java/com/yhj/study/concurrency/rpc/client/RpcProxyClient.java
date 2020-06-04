package com.yhj.study.concurrency.rpc.client;

import java.lang.reflect.Proxy;

/**
 * @date: 2019/06/06 11:42
 */
public class RpcProxyClient {

    public<T> T clientProxy(final Class<T> interfaceCls, final String host, final int port){

        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls}, new RemoteInvocationHandler(host, port));
    }

}

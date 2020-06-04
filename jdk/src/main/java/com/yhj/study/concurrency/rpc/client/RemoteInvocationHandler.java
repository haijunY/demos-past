package com.yhj.study.concurrency.rpc.client;

import com.yhj.study.concurrency.rpc.provider.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @date: 2019/06/06 11:46
 */
public class RemoteInvocationHandler implements InvocationHandler{

    private String host;

    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //
        System.out.println("come in");
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setVersion("2.0");
        rpcRequest.setParameters(args);

        RpcNetTransport netTransport = new RpcNetTransport(host, port);
        Object result = netTransport.send(rpcRequest);
        return result;
    }
}

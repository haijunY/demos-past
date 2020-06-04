package com.yhj.study.concurrency.rpc.provider;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

/**
 * @date: 2019/06/06 11:13
 */
public class ProcessorHandler implements Runnable {

    private Socket socket;

    private Object service;

    private Map<String, Object> handlerMap;

    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    public ProcessorHandler(Socket socket, Map<String, Object> handlerMap) {
        this.socket = socket;
        this.handlerMap = handlerMap;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            //输出流应该有什么？
            //请求那个类、方法名称、参数
            RpcRequest rpcRequest = (RpcRequest)objectInputStream.readObject();
            Object result = invoke(rpcRequest);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            if(null != objectInputStream){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != objectOutputStream){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private Object invoke(RpcRequest rpcRequest) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String serviceName = rpcRequest.getClassName();
        //增加版本号
        String version = rpcRequest.getVersion();
        if(!StringUtils.isEmpty(version)){
            serviceName += "-"+version;
        }
        Object service = handlerMap.get(serviceName);
        if(null == service){
            throw new RuntimeException("service not found: " + rpcRequest.getClassName());
        }
        //反射调用
        Object[] args = rpcRequest.getParameters();
        Class<?>[] types = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            types[i] = args[i].getClass();
        }
        Class clazz = Class.forName(rpcRequest.getClassName());
        Method method = clazz.getMethod(rpcRequest.getMethodName(), types);
        return method.invoke(service, args);
    }


}

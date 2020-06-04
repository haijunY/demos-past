package com.yhj.study.concurrency.rpc.client;

import com.yhj.study.concurrency.rpc.provider.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @date: 2019/06/06 11:54
 */
public class RpcNetTransport {

    private String host;

    private int port;

    public RpcNetTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Object send(RpcRequest rpcRequest){
        Socket socket = null;
        Object result = null;
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try{
            socket = new Socket(host, port);//建立连接
            outputStream = new ObjectOutputStream(socket.getOutputStream());//网络socket
            outputStream.writeObject(rpcRequest);//序列化
            outputStream.flush();

            inputStream = new ObjectInputStream(socket.getInputStream());
            result=inputStream.readObject();

        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != outputStream){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            if (null != socket){
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        return result;
    }

}

package com.yhj.study.concurrency.rpc.provider;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @date: 2019/06/06 11:08
 */
public class RpcProxyServer {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(int port, Object service){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            while (true) {//不断接受请求
                Socket socket = serverSocket.accept();
                //每一个socket交给一个processorHandler来处理
                executorService.execute(new ProcessorHandler(socket, service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != serverSocket){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

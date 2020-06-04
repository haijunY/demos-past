package com.yhj.study.concurrency.netty;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @date: 2019/05/31 17:34
 */
public class ServerSocketDemo1 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try{
            //服务端一定要去监听一个端口号，ip默认本机
            serverSocket = new ServerSocket(8080);

            Socket socket = serverSocket.accept();//接受客户端的连接（阻塞）
            //拿到输入流
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //输出流
            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            //通过控制台拿数据
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client: "+ in.readLine());//获得输入流信息
            String line = sin.readLine();
            while (!line.equals("bye")){
                pw.println(line);//写回到客户端
                pw.flush();
                System.out.println("Client:" + sin.readLine());//读取客户端传过来的数据
                line = sin.readLine();//重新读取控制台的数据
            }

            System.out.println(in.readLine());//获得客户端的输入信息


        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

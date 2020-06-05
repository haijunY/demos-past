package com.yhj.study.concurrency.netty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @date: 2019/05/31 17:39
 */
public class ClientSocketDemo1 {

    public static void main(String[] args) {
        try{
            //找到目标的ip端口
            Socket socket = new Socket("localhost",8080);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello!!静静");
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String readLine = sin.readLine();
            while (!readLine.equals("bye")){
                out.println(readLine);
                out.flush();
                System.out.println("Server:" + in.readLine());
                readLine = sin.readLine();//重新获取
            }



        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

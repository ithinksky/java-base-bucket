package com.ithinksky.java.n11net.tcp.t001;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 一个简单的 Tcp Server
 *
 * @author tengpeng.gao
 * @since 2019/3/11
 */
public class TcpServer {

    public static void main(String[] args) throws IOException {

        // 1. 初始化服务端socket连接，并监听8888端口的socket请求
        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("****** I am Server, now begin to wait the client ******");
        while (true) {
            Socket socket = serverSocket.accept();

            // 2. server 接收消息
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String buffer = null;
            while ((buffer = bufferedReader.readLine()) != null) {
                System.out.println("I am Server, now get message from Client: " + buffer);
            }
            socket.shutdownInput();

            // 3. server 发送消息
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("HTTP/1.1 200 OK \r\n Content-Type:text/html \r\n charset=UTF-8 \r\n\r\n");
            bufferedWriter.write("[welcome to you!]");
            bufferedWriter.flush();

            // 4. 关闭资源
            bufferedReader.close();
            bufferedWriter.close();
            socket.close();
        }


    }

}

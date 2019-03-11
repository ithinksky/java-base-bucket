package com.ithinksky.java.n11net.tcp.t001;

import java.io.*;
import java.net.Socket;

/**
 * 一个简单的 Tcp Client
 *
 * @author tengpeng.gao
 * @since 2019/3/11
 */
public class TcpClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 8888);

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.write("发起一个客户端请求：我是Java工程师");
        printWriter.flush();

        socket.shutdownOutput();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String buffer = null;
        while ((buffer = bufferedReader.readLine()) != null) {
            System.out.println("收到服务端消息：" + buffer);
        }

        printWriter.close();
        socket.close();
    }


}

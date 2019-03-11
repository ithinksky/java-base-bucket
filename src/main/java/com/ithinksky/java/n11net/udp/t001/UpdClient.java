package com.ithinksky.java.n11net.udp.t001;

import java.io.IOException;
import java.net.*;

/**
 * 一个简单的 UDP Client
 *
 * @author tengpeng.gao
 * @since 2019/3/11
 */
public class UpdClient {

    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getByName("localhost");
        byte[] data = "发起一个客户端请求：我是Java工程师".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, inetAddress, 8800);
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(datagramPacket);

        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(datagramPacket1);
        String info = new String(buffer, 0, buffer.length);
        System.out.println("I am Client, Server say:" + info);

        datagramSocket.close();

    }

}

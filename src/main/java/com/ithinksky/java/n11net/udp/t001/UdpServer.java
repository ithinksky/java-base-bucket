package com.ithinksky.java.n11net.udp.t001;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 一个简单的 UDP Server
 *
 * @author tengpeng.gao
 * @since 2019/3/11
 */
public class UdpServer {

    public static void main(String[] args) throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(8800);

        // 接收消息
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket);
        String info = new String(bytes, 0, bytes.length);
        System.out.println("I am Server, Client say: " + info);

        // 发送消息
        InetAddress inetAddress = datagramPacket.getAddress();
        int port = datagramPacket.getPort();
        byte[] data = "welcome".getBytes();
        DatagramPacket datagramPacket1 = new DatagramPacket(data, data.length, inetAddress, port);
        datagramSocket.send(datagramPacket1);

        datagramSocket.close();

    }

}

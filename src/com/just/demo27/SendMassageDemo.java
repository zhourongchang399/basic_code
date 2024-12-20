package com.just.demo27;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SendMassageDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        String s = null;
        InetAddress address = InetAddress.getByName("127.0.0.1");
        Integer port = 10086;

        while (!(s = scanner.next()).equals("886")) {
            byte[] bytes = s.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, address, port);
            datagramSocket.send(datagramPacket);
        }

        datagramSocket.close();
    }
}

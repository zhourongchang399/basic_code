package com.just.demo27;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveMassageDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(10086);

        String s = null;
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

        do {
            datagramSocket.receive(datagramPacket);
            s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(s);
        } while (!s.equals("886"));

        datagramSocket.close();
    }
}

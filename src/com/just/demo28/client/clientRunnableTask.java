package com.just.demo28.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class clientRunnableTask implements Runnable{

    Socket socket;

    public clientRunnableTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 不断循环读取消息
        try {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true) {
            String massage = bufferedReader.readLine();
            System.out.println(massage);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.just.demo27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        char[] chars = new char[1024];
        int len = -1;
        while((len = bufferedReader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
        bufferedReader.close();
        socket.close();
        serverSocket.close();
    }
}

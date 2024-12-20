package com.just.demo27;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10086);
        OutputStream outputStream = null;

        while (true) {
            System.out.println("请输入需要发送的数据（exit:退出）：");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if (s.equals("exit")) {
                break;
            }
            outputStream = socket.getOutputStream();
            outputStream.write(s.getBytes());
        }

        outputStream.close();
        socket.close();
    }
}

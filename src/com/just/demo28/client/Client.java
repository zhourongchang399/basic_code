package com.just.demo28.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        // 与服务器创建连接
        String host = "127.0.0.1";
        int port = 10086;
        Socket socket = new Socket(host, port);
        Scanner scanner = new Scanner(System.in);

        while (socket != null) {
            System.out.println("服务器已经连接成功\n" +
                    "==============欢迎来到JUST聊天室================\n" +
                    "1登录\n" +
                    "2注册\n" +
                    "3退出\n" +
                    "请输入您的选择：");

            String keys;
            if ((keys = scanner.nextLine()).length() == 1) {
                int op = Integer.parseInt(keys);
                String result;
                switch (op) {
                    case 1:
                        // 登录
                        login(socket, scanner);
                        // 判断登录是否成功
                        result = getRespond(socket);
                        if (result.equals("登录成功")) {
                            System.out.println(result);
                            // 开始聊天
                            chats(socket, scanner);
                        } else {
                            System.out.println(result + ",请重新登录！");
                        }
                        break;
                    case 2:
                        // 注册
                        register(socket, scanner);
                        // 判断注册是否成功
                        result = getRespond(socket);
                        if (result.equals("注册成功")) {
                            System.out.println(result);
                        } else {
                            System.out.println(result + ",请重新注册！");
                        }
                        break;
                    case 3:
                        // 退出
                        socket.close();
                        System.exit(0);
                        break;
                }
            } else {
                System.out.println("没有该操作，请重新输入！");
            }

        }
    }

    private static void chats(Socket socket, Scanner scanner) throws IOException {
        System.out.println("==============JUST聊天室================");
        // 启动接受消息线程
        new Thread(new clientRunnableTask(socket)).start();

        // 发送消息
        String massage = null;
        while (!((massage = scanner.nextLine()).equals("886"))) {
            sendRequest(socket, "operation=3&massage=" + massage);
        }

        // 退出聊天室
        sendRequest(socket, "operation=4&massage=退出了聊天室...");
        System.out.println("退出聊天室...");
        socket.close();
        System.out.println("断开服务器连接...");
        System.exit(0);
    }

    private static void register(Socket socket, Scanner scanner) throws IOException {
        // 注册
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        String request = "username=" + username + "&password=" + password;

        // 向服务器发送注册请求
        sendRequest(socket, "operation=2&" + request);
    }

    // 获取服务器回应
    private static String getRespond(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String respond = reader.readLine();
        return respond;
    }

    // 向服务器发送请求
    private static void sendRequest(Socket socket, String request) throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(request);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    // 登录
    private static void login(Socket socket, Scanner scanner) throws IOException {
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        String request = "username=" + username + "&password=" + password;

        // 向服务器发送登录请求
        sendRequest(socket, "operation=1&" + request);
    }

}

package com.just.demo28.server;

import cn.hutool.core.io.FileUtil;
import com.just.demo28.domain.User;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class runnableTask implements Runnable {

    Socket socket;
    ArrayList<Socket> sockets;
    ArrayList<User> users;
    boolean state = false;
    String username;
    String password;

    public runnableTask(Socket socket, ArrayList<User> users, ArrayList<Socket> sockets) {
        this.socket = socket;
        this.users = users;
        this.sockets = sockets;
    }

    @Override
    public void run() {
        try {
            // 与客户端创建输入流
            InputStream socketInputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socketInputStream));
            while (true) {
                String request = bufferedReader.readLine();
                System.out.println(request);
                String[] Info = request.split("&");
                int operation = Integer.parseInt(Info[0].split("=")[1]);
                if (state) {
                    if (operation == 3 || operation == 4) {
                        // 读取聊天内容
                        String massage = Info[1].split("=")[1];
                        // 向每个聊天室内的客户端发送信息
                        for (Socket subSocket : sockets) {
                            if (subSocket != socket) {
                                serverResult(subSocket, username + ":" + massage);
                            }
                        }
                        if (operation == 4) {
                            System.out.println(Thread.currentThread().getName() + ":" + "断开连接");
                        }
                    }
                } else {
                    if (operation == 1) {
                        // 读取登录信息
                        username = Info[1].split("=")[1];
                        password = Info[2].split("=")[1];
                        state = login(username, password);
                    } else if (operation == 2) {
                        // 读取注册信息
                        username = Info[1].split("=")[1];
                        password = Info[2].split("=")[1];
                        if (register(username, password)) {
                            saveRegisterInfo(username, password);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }

    // 保存注册信息
    private void saveRegisterInfo(String username, String password) {
        users.add(new User(username, password));
        File userFile = new File("src/com/just/demo28/save/users.txt");
        FileUtil.appendString("\nusername=" + username + "&password=" + password, userFile, "UTF-8");
    }

    // 注册
    private boolean register(String username, String password) throws IOException {
        String result = "注册成功";
        if(contains(username)) {
            result = "用户名重复";
            serverResult(socket, result);
            System.out.println(Thread.currentThread().getName() + result);
            return false;
        }
        if (!checkUsername(username, "[A-Za-z]+")){
            result = "用户名格式错误";
            serverResult(socket, result);
            System.out.println(Thread.currentThread().getName() + result);
            return false;
        }
        if (!checkPassword(password, "[A-Za-z]\\d+")) {
            result = "密码格式错误";
            serverResult(socket, result);
            System.out.println(Thread.currentThread().getName() + result);
            return false;
        }
        serverResult(socket, result);
        return true;
    }

    // 判断用户名格式是否正确
    private boolean checkUsername(String username, String regex) {
        if ((username.length() >= 6 && username.length() <= 18) && username.matches(regex)){
            return true;
        }
        return false;
    }

    // 判断密码格式是否正确
    private boolean checkPassword(String password, String regex) {
        if ((password.length() >= 3 && password.length() <= 8) && password.matches(regex)){
            return true;
        }
        return false;
    }

    // 判断是否存在该用户
    private boolean contains(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    // 登录
    private boolean login(String username, String password) throws IOException {
        String result = null;
        switch (checkLogin(username, password)) {
            case 0:
                result = "用户名不存在";
                serverResult(socket, result);
                System.out.println(Thread.currentThread().getName() + result);
                return false;
            case 1:
                result = "密码错误";
                serverResult(socket, result);
                System.out.println(Thread.currentThread().getName() + result);
                return false;
            case 2:
                result = "登录成功";
                serverResult(socket, result);
                System.out.println(Thread.currentThread().getName() + ":" + username + result);
                break;
        }
        return true;
    }

    private void serverResult(Socket socket, String result) throws IOException {
        // 与客户端创建输出流并返回客户端
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write(result);
        writer.newLine();
        writer.flush();
    }

    private int checkLogin(String username, String password) {
        // 判断登录登录信息是否正确
        for (User user : users) {
            if (user.getUsername().equals(username)){
                if (user.getPassword().equals(password)) {
                    // 登录成功
                    return 2;
                } else {
                    // 密码错误
                    return 1;
                }
            }
        }
        // 用户名不存在
        return 0;
    }
}

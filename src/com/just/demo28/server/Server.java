package com.just.demo28.server;

import cn.hutool.core.io.FileUtil;
import com.just.demo28.domain.User;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Server {

    public static void main(String[] args) throws IOException {

        ArrayList<Socket> socketArrayList = new ArrayList<>();
        ArrayList<User> users;
        File usersFile = new File("src/com/just/demo28/save/users.txt");
        List<String> userInfos = FileUtil.readLines(usersFile, "UTF-8");
        users = (ArrayList<User>) userInfos.stream()
                .map(s -> {
                        String[] strings = s.split("&");
                        String username = strings[0].split("=")[1];
                        String password = strings[1].split("=")[1];
                        return new User(username, password);
                    })
                .collect(Collectors.toList());

        // 创建线程池管理子线程
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,
                9,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        // 创建服务器Socket
        ServerSocket serverSocket = new ServerSocket(10086);

        // 监听客户端连接
        while (true) {
            Socket accept = serverSocket.accept();
            socketArrayList.add(accept);
            threadPoolExecutor.submit(new runnableTask(accept, users, socketArrayList));
        }

    }
}

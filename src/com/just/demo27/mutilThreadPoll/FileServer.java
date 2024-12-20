package com.just.demo27.mutilThreadPoll;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FileServer {
    public static void main(String[] args) throws IOException {

        // 创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(10086);

        // 创建线程池管理线程
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3 // 核心线程数量
                , 9 // 最大线程数
                , 60 // 等待时间
                , TimeUnit.SECONDS // 等待时间单位
                , new ArrayBlockingQueue<>(3) // 阻塞队列
                , Executors.defaultThreadFactory() // 线程创造的方式
                , new ThreadPoolExecutor.AbortPolicy()); // 拒绝策略

        while (true) {
            // 监听客户端连接
            Socket socket = serverSocket.accept();

            // 创建线程执行任务
            FileRunnable fileRunnable = new FileRunnable(socket);
            threadPoolExecutor.submit(fileRunnable);
        }

    }
}

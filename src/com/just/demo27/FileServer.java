package com.just.demo27;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class FileServer {
    public static void main(String[] args) throws IOException {

        // 创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(10086);

        // 监听客户端连接
        Socket socket = serverSocket.accept();

        // 与文件Client建立输入流
        InputStream inputStream = socket.getInputStream();

        // 读取数据并保存到本地
        String fileName = UUID.randomUUID().toString().replace("-", "") + ".txt";
        File file = new File("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo27\\ServerFile", fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bytes = new byte[1024 * 1024];
        int len = -1;
        while ((len = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        System.out.println("文件保存成功！");

        // 返回上传成功信息
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        String re = "上传成功！";
        bufferedWriter.write(re);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        // 关闭ServerSocket
        socket.close();
        serverSocket.close();

    }
}

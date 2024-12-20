package com.just.demo27;

import cn.hutool.core.io.FileUtil;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class FileClient {
    public static void main(String[] args) throws IOException {

        // 读取Client文件
        File file = new File("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo27\\ClientFile\\data.txt");
        List<String> strings = FileUtil.readLines(file, "UTF-8");

        // 与文件Server建立连接，并发送信息
        Socket socket = new Socket("127.0.0.1", 10086);
        OutputStream outputStream = socket.getOutputStream();
        for (String string : strings) {
            outputStream.write(string.getBytes());
        }

        // 关闭输出流
        socket.shutdownOutput();

        // 与文件Server建立输入流
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        // 读取返回数据
        char[] chars = new char[1024];
        int len = -1;
        while ((len = bufferedReader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }

        // 关闭连接
        socket.close();

    }
}

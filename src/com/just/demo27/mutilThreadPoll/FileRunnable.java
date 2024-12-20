package com.just.demo27.mutilThreadPoll;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class FileRunnable implements Runnable{

    Socket socket;

    public FileRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 与文件Client建立输入流
            InputStream inputStream = socket.getInputStream();

            // 读取数据并保存到本地
            String fileName = UUID.randomUUID().toString().replace("-", "") + ".txt";
            File file = new File("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo27\\mutilThreadPoll\\ServerFile", fileName);
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

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                // 关闭ServerSocket
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package com.just.demo23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDir {
    public static void main(String[] args) throws IOException {
        File oriPath = new File("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo23\\ori");
        File destPath = new File("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo23\\dest");

        copyDir(oriPath, destPath);
    }

    private static void copyDir(File oriPath, File destPath) throws IOException {
        destPath.mkdir();

        File[] files = oriPath.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    copyDir(file, new File(destPath, file.getName()));
                } else if (file.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(destPath, file.getName()));
                    byte[] bytes = new byte[1024 * 1024];
                    int len;
                    while ((len = fileInputStream.read(bytes)) != -1) {
                        fileOutputStream.write(bytes, 0, len);
                    }

                    fileOutputStream.close();
                    fileInputStream.close();
                }
            }
        }
    }
}

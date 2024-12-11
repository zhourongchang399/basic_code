package com.just.demo22;

import java.io.File;

public class SearchFile {
    public static void main(String[] args) {
        String pathname = "C:\\Users\\49744\\Desktop";
        File root = new File(pathname);
        searchFile(root);
    }

    public static void searchFile(File file) {
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            if (subFiles != null)
                for (File subFile : subFiles) {
                    searchFile(subFile);
                }
        } else if (file.isFile() && file.getName().endsWith(".pdf")) {
            System.out.println(file.getAbsoluteFile());
        }
    }
}

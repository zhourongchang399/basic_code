package com.just.demo22;

import java.io.File;
import java.util.*;

public class CountFile {
    public static void main(String[] args) {
        String pathname = "C:\\Users\\49744\\Desktop\\GLoFT";
        File file = new File(pathname);
        Map<String, Integer> fileTypeCount = new HashMap<>();
        fileTypeCount = countFile(file);
        Set<Map.Entry<String, Integer>> entries = fileTypeCount.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static Map<String, Integer> countFile(File file) {
        Map<String, Integer> fileTypeCount = new HashMap<>();
        Map<String, Integer> subFileTypeCount = new HashMap<>();
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    subFileTypeCount = countFile(subFile);
                    Set<Map.Entry<String, Integer>> entries = subFileTypeCount.entrySet();
                    for (Map.Entry<String, Integer> entry : entries) {
                        if (fileTypeCount.containsKey(entry.getKey())) {
                            fileTypeCount.put(entry.getKey(), entry.getValue() + fileTypeCount.get(entry.getKey()));
                        } else {
                            fileTypeCount.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            }
        } else if (file.isFile()) {
            String fileName = file.getName();
            String[] strings = fileName.split("\\.");
            if (fileTypeCount.containsKey(strings[1])) {
                fileTypeCount.put(strings[1], fileTypeCount.get(strings[1]) + 1);
            } else {
                fileTypeCount.put(strings[1], 1);
            }
        }
        return fileTypeCount;
    }

}

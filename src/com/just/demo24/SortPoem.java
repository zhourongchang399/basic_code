package com.just.demo24;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortPoem {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo24\\pome.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split("\\.");
            treeMap.put(Integer.parseInt(split[0]), split[1]);
        }

        bufferedReader.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo24\\sort_poem.txt"));
        Set<Map.Entry<Integer, String>> entrySet = treeMap.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet) {
            bufferedWriter.write(entry.getKey() + "." + entry.getValue());
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}

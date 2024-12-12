package com.just.demo23;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortFile {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo23\\number");
        FileReader fileReader = new FileReader(file);
        char[] arrStr = new char[1];
        int len;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = fileReader.read(arrStr)) != -1) {
            stringBuilder.append(arrStr[0]);
        }
        Integer[] integers = Arrays.stream(stringBuilder.toString().split("-"))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(integers));
        String s = Arrays.toString(integers).replace(",", "-");
        String result = s.substring(1, s.length() - 1);
        System.out.println(result);

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(result);

        fileReader.close();
        fileWriter.close();
    }
}

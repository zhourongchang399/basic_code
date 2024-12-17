package com.just.demo25;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomRollCall3 {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo25\\person.txt");
        File countFile = new File("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo25\\countFile.txt");
        int readCount = 0;
        if (countFile.exists()) {
            FileReader countFileReader = new FileReader(countFile);
            readCount = Integer.parseInt(String.valueOf((char) countFileReader.read()));
            readCount++;
            FileWriter countFileWriter = new FileWriter(countFile);
            countFileWriter.write(readCount + "");
            countFileReader.close();
            countFileWriter.close();
        } else {
            FileWriter countFileWriter = new FileWriter(countFile);
            countFileWriter.write("1");
            countFileWriter.close();
        }

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s;
        ArrayList<String> persons = new ArrayList<>();
        while ((s = bufferedReader.readLine()) != null) {
            persons.add(s.split("-")[0]);
        }
        bufferedReader.close();

        Random random = new Random();
        int i = random.nextInt(persons.size());
        if (readCount == 3) {
            System.out.println("周星驰");
        } else {
            System.out.println(persons.get(i));
        }

    }
}

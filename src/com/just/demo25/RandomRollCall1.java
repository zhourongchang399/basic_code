package com.just.demo25;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class RandomRollCall1 {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo25\\person.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Random random = new Random();
        int i = random.nextInt(100);
        String[] split = null;
        for (int i1 = 0; i1 < i; i1++) {
            split = bufferedReader.readLine().split("-");
        }
        System.out.println(split[0]);
        bufferedReader.close();

    }
}

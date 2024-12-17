package com.just.demo25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandomRollCall2 {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo25\\person.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s;
        ArrayList<String> boys = new ArrayList<>();
        ArrayList<String> girls = new ArrayList<>();
        while ((s = bufferedReader.readLine()) != null) {
            String[] split = s.split("-");
            if (split[2].equals("男")) {
                boys.add(split[0]);
            } else {
                girls.add(split[0]);
            }
        }
        bufferedReader.close();
        ArrayList<String> rollCallBoys = new ArrayList<>();
        ArrayList<String> rollCallGirls = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            int j = random.nextInt(10);
            if (j < 7) {
                Collections.shuffle(boys);
                rollCallBoys.add(boys.get(0));
            } else {
                Collections.shuffle(girls);
                rollCallGirls.add(girls.get(0));
            }
        }
        System.out.println(rollCallBoys.size() + "," + rollCallGirls.size());
    }
}

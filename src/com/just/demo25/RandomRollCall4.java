package com.just.demo25;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class RandomRollCall4 {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo25\\person.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s;
        ArrayList<String> persons = new ArrayList<>();
        while ((s = bufferedReader.readLine()) != null) {
            persons.add(s.split("-")[0]);
        }
        bufferedReader.close();

        HashSet<Object> hashSet = new HashSet<>();
        Collections.shuffle(persons);
        for (int i1 = 0; i1 < 1000; i1++) {

            if (hashSet.size() == persons.size()) {
                hashSet = new HashSet<>();
                Collections.shuffle(persons);
                System.out.println("---------------------------------END---------------------------------");
            }

            while (hashSet.contains(persons.get(0))){
                Collections.shuffle(persons);
            }
            hashSet.add(persons.get(0));
            System.out.println(persons.get(0));
        }
    }
}

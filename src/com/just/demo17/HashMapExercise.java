package com.just.demo17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class HashMapExercise {
    public static void main(String[] args) {
        String[] arr = {"A","B","C","D"};
        Random r = new Random();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(arr[r.nextInt(4)]);
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i))){
                int count = map.get(list.get(i)) + 1;
                map.put(list.get(i), count);
            } else {
                map.put(list.get(i), 1);
            }
        }

        int max = -1;
        Set<String> keys = map.keySet();
        for (String s : keys) {
            if (map.get(s) > max){
                max = map.get(s);
            }
        }

        for (String s : keys) {
            if (map.get(s) == max){
                System.out.println(s + "," + map.get(s));
            }
        }

    }
}

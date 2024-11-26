package com.just.demo17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class TreeMapExercise {
    public static void main(String[] args) {
        String[] arr = {"A","B","C","D","E"};
        Random random = new Random();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(arr[random.nextInt(4)]);
        }

        TreeMap<String, Integer> treeMap = new TreeMap<>((o1, o2) -> o2.compareTo(o1));
        for (int i = 0; i < list.size(); i++) {
            if (treeMap.containsKey(list.get(i))){
                int count = treeMap.get(list.get(i));
                count++;
                treeMap.put(list.get(i), count);
            } else {
                treeMap.put(list.get(i), 1);
            }
        }

        treeMap.forEach((String s, Integer integer) -> System.out.println(s + ":" + integer));

    }
}

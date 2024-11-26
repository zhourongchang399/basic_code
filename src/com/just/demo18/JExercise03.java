package com.just.demo18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class JExercise03 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "伍六七","梅小姐","鸡大宝","江主任","赤牙","斯特国王子","汪疯","小咪","陈伯");
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int count = 0;
            int[] arr = new int[arrayList.size()];
            while (count != arrayList.size()) {
                int index = random.nextInt(arrayList.size());
                if (arr[index]++ == 0) {
                    System.out.println(arrayList.get(index));
                    count++;
                    arr[index]++;
                }
            }
            System.out.println("重新点名");
        }
    }
}

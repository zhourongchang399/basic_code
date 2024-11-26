package com.just.demo18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class JExercise01 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "伍六七","梅小姐","鸡大宝","江主任","赤牙","斯特国王子","汪疯","小咪","陈伯");
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            System.out.println(arrayList.get(random.nextInt(arrayList.size())));
        }

        for (int i = 0; i < 5; i++) {
            Collections.shuffle(arrayList);
            System.out.println(arrayList.get(i));
        }
    }
}

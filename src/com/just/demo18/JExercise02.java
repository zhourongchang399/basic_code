package com.just.demo18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class JExercise02 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 1,1,1,1,1,1);
        Collections.addAll(arrayList, 0,0,0);
        ArrayList<String> manList = new ArrayList<>();
        ArrayList<String> womanList = new ArrayList<>();
        Collections.addAll(manList, "伍六七","鸡大宝","赤牙","斯特国王子","汪疯","陈伯");
        Collections.addAll(womanList,"梅小姐","江主任","小咪");

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int state = random.nextInt(arrayList.size());
            if (arrayList.get(state) == 1){
                System.out.println(manList.get(random.nextInt(manList.size())));
            } else {
                System.out.println(womanList.get(random.nextInt(womanList.size())));
            }
        }
    }
}

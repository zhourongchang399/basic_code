package com.just.demo18;

import java.util.*;

public class JExercise04 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        Collections.addAll(arrayList1,"天河区","黄埔区","南沙区","番禺区","越秀区","荔湾区");
        Collections.addAll(arrayList2,"沙田镇","虎门镇","厚街镇","寮步镇","大朗镇","塘厦镇");
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        hashMap.put("广州市", arrayList1);
        hashMap.put("东莞市", arrayList2);
        Set<Map.Entry<String, ArrayList<String>>> entries = hashMap.entrySet();
        for (Map.Entry<String, ArrayList<String>> entry : entries) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            StringJoiner stringJoiner = new StringJoiner(",","","");
            for (String s : value) {
                stringJoiner.add(s);
            }
            System.out.println(key + "=" + stringJoiner);
        }
    }
}

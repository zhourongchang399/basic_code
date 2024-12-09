package com.just.demo20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class dataOperator {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList,"zhangsan,23","lisi,24","wangwu,25");
        Map<String, Integer> objectMap = arrayList.stream()
                .filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
                .collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));
        Set<Map.Entry<String, Integer>> entries = objectMap.entrySet();
        entries.forEach(s -> System.out.println(s.getKey() + ":" + s.getValue()));
    }
}

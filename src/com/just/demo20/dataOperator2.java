package com.just.demo20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class dataOperator2 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "周星驰，23", "周润发,24","张国荣,25","黎明,26","刘德华,27","林峰,28");
        ArrayList<String> arrayList1 = new ArrayList<>();
        Collections.addAll(arrayList1, "周慧敏，23", "李嘉欣,24","薛凯琪,25","邓紫棋,26","单依纯,27","李宇春,28");
        Stream<String> stringStream = arrayList.stream()
                .filter(s -> s.split(",")[0].length() == 3)
                .limit(2);
        Stream<String> stringStream1 = arrayList1.stream()
                .filter(s -> s.split(",")[0].startsWith("李"));
        List<Actor> actors = Stream.concat(stringStream, stringStream1)
                .map(s -> new Actor(s.split(",")[0], Integer.parseInt(s.split(",")[1]))).collect(Collectors.toList());
        actors.forEach(s -> System.out.println(s));
    }
}

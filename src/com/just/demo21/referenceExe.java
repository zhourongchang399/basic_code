package com.just.demo21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class referenceExe {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "周星驰,23", "周润发,24","张国荣,25","黎明,26","刘德华,27","林峰,28");
        Student[] students = arrayList.stream().map(Student::new).toArray(Student[]::new);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

package com.just.demo21;

import java.util.ArrayList;
import java.util.stream.Stream;

public class referenceExe2 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("刘德华,23"));
        students.add(new Student("黎明,24"));
        students.add(new Student("郭富城,25"));
        students.add(new Student("张学友,26"));

        String[] strings = students.stream().map(Student::concat).toArray(String[]::new);

        for (String string : strings) {
            System.out.println(string);
        }
    }
}

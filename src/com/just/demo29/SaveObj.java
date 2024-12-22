package com.just.demo29;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class SaveObj {
    public static void main(String[] args) throws IllegalAccessException, IOException {

        Student student = new Student("张三", 18, "男");
        saveObject(student);

    }

    public static void saveObject(Object o) throws IllegalAccessException, IOException {
        Class clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/com/just/demo29/obj.txt"));
        for (Field field : fields) {
            bufferedWriter.write(field.getName() + "=" + field.get(o));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}

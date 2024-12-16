package com.just.demo24;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ObjectSeries {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<Person> personArrayList = new ArrayList<>();
        Collections.addAll(personArrayList, new Person("Marry", 18, "USA"), new Person("Woot", 24, "UK"));

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo24\\object.txt"));
        objectOutputStream.writeObject(personArrayList);

        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo24\\object.txt"));
        ArrayList<Person> personArrayList1 = (ArrayList<Person>) objectInputStream.readObject();
        for (Person person : personArrayList1) {
            System.out.println(person);
        }

        objectInputStream.close();

    }
}

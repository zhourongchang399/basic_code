package com.just.demo15;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise01 {
    public static void main(String[] args) {
        Person person1 = new Person("mike", 18,180);
        Person person2 = new Person("jack",22,200);
        Person person3 = new Person("marry", 16, 170);
        Person person4 = new Person("james", 18, 206);
        Person person5 = new Person("john", 18, 206);
        Person person6 = new Person("johns", 18, 206);

        Person[] personArrayList = new Person[6];
        personArrayList[0] = person1;
        personArrayList[1] = person2;
        personArrayList[2] = person3;
        personArrayList[3] = person4;
        personArrayList[4] = person5;
        personArrayList[5] = person6;

        Arrays.sort(personArrayList, ((o1, o2) -> {
            if (o1.getAge() != o2.getAge()){
                return o1.getAge() - o2.getAge();
            } else if (o1.getHigh() != o2.getHigh()){
                return (int)(o1.getHigh() - o2.getHigh());
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        }));

        System.out.println(Arrays.toString(personArrayList));
    }
}

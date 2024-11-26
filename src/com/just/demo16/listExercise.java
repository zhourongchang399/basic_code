package com.just.demo16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class listExercise {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("ccc")) {
                it.remove();
            }
        }

        list.forEach(s -> System.out.println(s));

        ListIterator<String> lit = list.listIterator();
        while (lit.hasNext()) {
            if (lit.next().equals("bbb")) {
                lit.add("qqq");
            }
        }

        for (String s : list) {
            System.out.println(s);
        }

    }
}

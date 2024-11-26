package com.just.demo16;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetExercise {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len = o1.length() - o2.length();
                int r = len == 0 ? o1.compareTo(o2) : len;
                return r;
            }
        });
        ts.add("cdssa");
        ts.add("abc");
        ts.add("cba");
        ts.add("efg");
        ts.add("cbad");
        System.out.println(ts);
    }
}

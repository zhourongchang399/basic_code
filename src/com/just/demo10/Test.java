package com.just.demo10;

public class Test {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(sb.equals(s1));
        System.out.println(s1.equals(sb.toString()));
    }
}

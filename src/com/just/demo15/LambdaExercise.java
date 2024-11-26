package com.just.demo15;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaExercise {
    public static void main(String[] args) {
        String[] arr = {"","a","aaa","aaaaaa","aaaaaaa", "aa"};
        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());
        System.out.println(Arrays.toString(arr));
    }
}

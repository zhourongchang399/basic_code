package com.just.demo15;

import java.util.Arrays;
import java.util.Comparator;

public class Array {
    public static void main(String[] args) {
        int[] list = {1,3,4,6,67,312,512,634,743,834,934,1000};
        System.out.println(Arrays.toString(list));
        System.out.println(Arrays.binarySearch(list, 0));
        System.out.println(Arrays.binarySearch(list, 1000));
        Arrays.fill(list,6);
        System.out.println(Arrays.toString(list));
        System.out.println(Arrays.toString(Arrays.copyOf(list, 6)));
        System.out.println(Arrays.toString(Arrays.copyOf(list, 100)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(list, 3,6)));
        int[] list1 = {10000, 1,3,4,6,67,312,512,634,743,834,934,1000};
        Arrays.sort(list1);
        System.out.println(Arrays.toString(list1));
        Integer[] listI = {10000, 1,3,4,6,67,312,512,634,743,834,934,1000};
        Arrays.sort(listI, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        });
        System.out.println(Arrays.toString(listI));
    }
}

package com.just.demo15;

import java.util.Arrays;

public class Exercise02 {
    public static void main(String[] args) {
//       0 1 1 2 3 5 8
        int arr[] = new int[12];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(function(12));
    }

    public static int function(int i){
        if (i == 1 || i == 2){
            return 1;
        }
        return function(i - 1) + function(i - 2);
    }

}

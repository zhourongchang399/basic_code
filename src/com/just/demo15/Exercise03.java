package com.just.demo15;

public class Exercise03 {
    public static void main(String[] args) {
        int total = 1;
        for (int i = 0; i < 9; i++) {
            total = (total + 1) * 2;
        }
        System.out.println(total);
        System.out.println(function(1));
    }

    public static int function(int i) {
        if (i == 10){
            return 1;
        }

        return (function(i + 1) + 1) * 2;
    }
}

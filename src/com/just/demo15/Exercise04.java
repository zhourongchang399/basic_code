package com.just.demo15;

import java.util.zip.CheckedOutputStream;

public class Exercise04 {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println(function(i));
        }
    }

    public static int function(int total) {
        if (total == 1 || total == 0) {
            return 1;
        }
        if (total == 2) {
            return 2;
        }
        if (total < 0) {
            return 0;
        }
        return function(total - 1) + function(total - 2) + function(total - 3);
    }
}

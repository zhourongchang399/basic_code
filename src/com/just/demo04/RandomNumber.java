package com.just.demo04;

import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        char[] charArr = str.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            Random random = new Random();
            int j = random.nextInt(charArr.length);
            char temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
        }

        str = new String(charArr);
        System.out.println(str.toString());
    }
}

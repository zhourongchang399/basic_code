package com.just.demo04;

public class ProductNumber {
    public static void main(String[] args) {
        String str1 = "1234567";
        String str2 = "123";

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int num1 = 0;
        int num2 = 0;
        for (int i = arr1.length - 1, j = 1; i >= 0; i--, j *= 10) {
            num1 += (arr1[i] - '0') * j;
        }
        for (int i = arr2.length - 1, j = 1; i >= 0; i--, j *= 10) {
            num2 += (arr2[i] - '0') * j;
        }

        int num = num1 * num2;
        StringBuilder sb = new StringBuilder();
        int i = 1;
        boolean state = true;
        while (true) {
            int remain = num / i % 10;
            num -= remain * i;
            if (num >= 0 && state) {
                sb.append(remain + "");
                i *= 10;
                if (num == 0) {
                    state = false;
                }
            } else {
                break;
            }
        }
        String result = sb.reverse().toString();
        System.out.println(result);
    }
}

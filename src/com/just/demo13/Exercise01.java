package com.just.demo13;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        while (true) {
            String input = scanner.nextLine();
            if (!input.matches("[1-9]\\d{0,9}")) {
                System.out.println("不能包含除数字外的字符！");
                continue;
            } else {
                char[] chars = input.toCharArray();
                for (int i = chars.length - 1, j = 1; i >= 0; i--, j *= 10) {
                    result += (chars[i] - '0') * j;
                }
                break;
            }
        }
        System.out.println(result);
    }
}

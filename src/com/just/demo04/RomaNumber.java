package com.just.demo04;

import java.util.Scanner;

public class RomaNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String number = new String();
        String romaNumber = "";
        while (true) {
            System.out.println("请输入一串数字：");
            number = sc.next();
            if (checkStr(number)) {
                for (int i = 0; i < number.length(); i++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(toRomaNumber(number.charAt(i)));
                    romaNumber = sb.toString();
                    System.out.println(romaNumber);
                }
                break;
            } else {
                System.out.println("输入错误，请重新输入！");
                continue;
            }
        }
    }

    public static boolean checkStr(String str) {
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp < '0' || temp > '9') {
                return false;
            }
        }
        return true;
    }

    public static String toRomaNumber(char c) {

        String result = "";
        switch (c) {
            case '0': {
                result = " ";
                break;
            }
            case '1': {
                result = "Ⅰ";
                break;
            }
            case '2': {
                result = "Ⅱ";
                break;
            }
            case '3': {
                result = "Ⅲ";
                break;
            }
            case '4': {
                result = "Ⅳ";
                break;
            }
            case '5': {
                result = "Ⅴ";
                break;
            }
            case '6': {
                result = "Ⅵ";
                break;
            }
            case '7': {
                result = "Ⅶ";
                break;
            }
            case '8': {
                result = "Ⅷ";
                break;
            }
            case '9': {
                result = "Ⅸ";
                break;
            }
            default: {
            }
        }
        return result;
    }
}

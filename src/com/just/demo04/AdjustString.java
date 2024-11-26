package com.just.demo04;

public class AdjustString {
    public static void main(String[] args) {
        String a = "abcde";
        String b = "cdeab";

        if (matchString(a, b)){
            System.out.println("匹配成功！");
        } else {
            System.out.println("匹配失败！");
        }

    }

    public static String adjustment(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(1));
        sb.append(str.substring(0,1));
        return sb.toString();
    }

    public static boolean matchString(String str1, String str2) {

        for (int i = 0; i < str1.length(); i++) {
            str1 = adjustment(str1);
            if (str1.equals(str2)){
                return true;
            }
        }
        return false;
    }
}

package com.just.demo13;

public class Exercise02 {
    public static void main(String[] args) {
        int num = 16;
        System.out.println(Integer.toBinaryString(num));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i = num % 2;
            num = num / 2;
            sb.append(i);
            if (num == 0){
                break;
            }
        }
        System.out.println(sb.reverse().toString());
    }
}

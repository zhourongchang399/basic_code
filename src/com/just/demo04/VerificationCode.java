package com.just.demo04;

import java.util.Random;

public class VerificationCode {
    public static void main(String[] args) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int countNumber = 0;
        while(true){
            switch (random.nextInt(3)){
                case 0 : {
                    if (countNumber == 0)
                        sb.append((char)('0' + random.nextInt(10)));
                    countNumber++;
                    break;
                }
                case 1 : {
                    sb.append((char)('a' + random.nextInt(26)));
                    break;
                }
                case 2 : {
                    sb.append((char)('A' + random.nextInt(26)));
                    break;
                }
                default:{}
            }
            if (sb.length() == 5){
                break;
            }
        }
        String code = sb.toString();
        System.out.println(code
        );
    }
}

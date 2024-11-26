package com.just.demo04;

import java.util.Scanner;

public class LowerCaseTransUpperCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lowerMoney = -1;

        while (true) {
            System.out.println("请输入金额：");
            lowerMoney = sc.nextInt();
            if (lowerMoney < 0 || lowerMoney > 9999999) {
                System.out.println("金额输入错误，请重新输入！");
            } else{
                System.out.println(transMoney(lowerMoney));
                break;
            }
        }

        sc.close();

    }

    public static String transMoney(int lowerMoney){
        String[] upperCaseNumber = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        String[] numberUnit = {"佰","拾","万","仟","佰","拾","元"};
        String result = "";
        for (int i = 0, j = 1; i < 7; i++, j *= 10) {
            result = upperCaseNumber[lowerMoney / j % 10] + numberUnit[6 - i] + result;
        }
        return result;
    }

}

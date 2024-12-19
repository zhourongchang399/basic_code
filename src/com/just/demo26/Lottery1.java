package com.just.demo26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;
import java.util.concurrent.FutureTask;

public class Lottery1 {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 1, 2, 5, 10, 20, 50, 100, 200, 500 ,1000);

        LotteryBox1 lotteryBox1 = new LotteryBox1(arrayList);
        LotteryBox1 lotteryBox2 = new LotteryBox1(arrayList);

        FutureTask<ArrayList<Integer>> futureTask1 = new FutureTask<>(lotteryBox1);
        FutureTask<ArrayList<Integer>> futureTask2 = new FutureTask<>(lotteryBox2);

        Thread t1 = new Thread(futureTask1);
        Thread t2 = new Thread(futureTask2);

        t1.setName("一号抽奖箱");
        t2.setName("二号抽奖箱");

        t1.start();
        t2.start();

        ArrayList<Integer> arrayList1 = futureTask1.get();
        ArrayList<Integer> arrayList2 = futureTask2.get();

        method(1, arrayList1);
        method(2, arrayList2);
    }

    private static void method(int index, ArrayList<Integer> arrayList) {
        StringJoiner stringJoiner = new StringJoiner(",");
        if (arrayList.size() != 0) {
            int total = 0;
            for (Integer integer : arrayList) {
                total += integer;
                stringJoiner.add(String.valueOf(integer));
            }
            System.out.println(index + "号抽奖箱产生了以下大奖：" + stringJoiner.toString());
            System.out.println("总共：" + total + "元");
        }
    }
}

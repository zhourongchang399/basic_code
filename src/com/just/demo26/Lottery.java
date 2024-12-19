package com.just.demo26;

import java.util.concurrent.ArrayBlockingQueue;

public class Lottery {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<>(1);

        PricePoll pricePoll = new PricePoll(abq);
        LotteryBox lotteryBox1 = new LotteryBox("一号抽奖箱", abq);
        LotteryBox lotteryBox2 = new LotteryBox("二号抽奖箱", abq);

        pricePoll.start();
        lotteryBox1.start();
        lotteryBox2.start();
    }
}

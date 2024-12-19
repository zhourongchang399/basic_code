package com.just.demo26;

import java.util.concurrent.ArrayBlockingQueue;

public class LotteryBox extends Thread {
    ArrayBlockingQueue<Integer> abq;

    public LotteryBox(ArrayBlockingQueue<Integer> abq) {
        this.abq = abq;
    }

    public LotteryBox(String name, ArrayBlockingQueue<Integer> abq) {
        super(name);
        this.abq = abq;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int price = abq.take();
                System.out.println(getName() + "抽出了" + price + "元大奖！");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

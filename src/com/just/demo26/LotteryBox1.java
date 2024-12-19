package com.just.demo26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class LotteryBox1 implements Callable<ArrayList<Integer>> {
    ArrayList<Integer> pricePoll;
    int maxPrice = 0;

    public LotteryBox1(ArrayList<Integer> pricePoll) {
        this.pricePoll = pricePoll;
        maxPrice = Collections.max(pricePoll);
    }

    @Override
    public ArrayList<Integer> call() throws Exception {
        ArrayList<Integer> priceList = new ArrayList<>();
        boolean flag = false;
        while (true) {
            synchronized (Lottery1.class) {
                if (pricePoll.size() == 0) {
                    if (flag) {
                        System.out.println(Thread.currentThread().getName() + "抽到了最大奖：" + maxPrice + "元！ ");
                    }
                    return priceList;
                } else {
                    Collections.shuffle(pricePoll);
                    if (pricePoll.get(0) == maxPrice) {
                        flag = true;
                    }
                    priceList.add(pricePoll.get(0));
                    pricePoll.remove(0);
                }
            }
        }
    }
}

package com.just.demo26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;

public class PricePoll extends Thread {

    ArrayBlockingQueue<Integer> abq;
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public PricePoll(ArrayBlockingQueue<Integer> abq) {
        this.abq = abq;
        Collections.addAll(arrayList, 1, 2, 5, 10, 20, 50, 100, 200, 500 ,1000);
    }

    public PricePoll(String name, ArrayBlockingQueue<Integer> abq) {
        super(name);
        this.abq = abq;
        Collections.addAll(arrayList, 1, 2, 5, 10, 20, 50, 100, 200, 500 ,1000);
    }

    @Override
    public void run() {
        while (true) {
            Collections.shuffle(arrayList);
            try {
                abq.put(arrayList.get(0));
                System.out.println("奖池产生了一个" + arrayList.get(0) + "元奖项！");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

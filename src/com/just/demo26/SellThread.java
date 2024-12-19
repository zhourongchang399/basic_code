package com.just.demo26;

public class SellThread extends Thread {

    static int count = 1000;

    @Override
    public void run() {
        while (true) {
            synchronized (SellThread.class) {
                if (count == 0) {
                    break;
                } else {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count--;
                    System.out.println(getName() + "买出了一张电影票，还剩" + count + "张！");
                }
            }
        }
    }
}

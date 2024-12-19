package com.just.demo26;

public class SellMovieTrick {
    public static void main(String[] args) {
        SellThread sellThread = new SellThread();
        SellThread sellThread1 = new SellThread();

        sellThread.setName("窗口1");
        sellThread1.setName("窗口2");

        sellThread.start();
        sellThread1.start();
    }
}

package com.just.demo26;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GivesThread extends Thread {

    static Lock lock = new ReentrantLock();

    static int count = 100;

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (count <= 10) {
                    break;
                } else {
                    Thread.sleep(100);
                    count--;
                    System.out.println(getName() + "送出了一份礼物,还剩下" + count + "份礼物！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

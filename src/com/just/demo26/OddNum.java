package com.just.demo26;

public class OddNum extends Thread {

    static int total = 1;

    @Override
    public void run() {
        while(true) {
            synchronized (OddNum.class) {
                if (total > 100) {
                    break;
                } else {
                    if (total % 2 == 0) {
                        total++;
                    } else {
                        System.out.println(getName() + ":" + total++);
                    }
                }
            }
        }
    }
}

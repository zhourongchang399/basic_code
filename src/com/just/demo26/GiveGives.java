package com.just.demo26;

public class GiveGives {
    public static void main(String[] args) {

        GivesThread givesThread = new GivesThread();
        GivesThread givesThread1 = new GivesThread();

        givesThread.setName("圣诞老人一号");
        givesThread1.setName("圣诞老人二号");

        givesThread.start();
        givesThread1.start();

    }
}

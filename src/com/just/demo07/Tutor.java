package com.just.demo07;

public class Tutor extends Teacher{

    public Tutor(int i, String name) {
        super(i,name);
    }
    public Tutor(){}
    @Override
    public void work() {
        super.work();
        System.out.println("备课");
    }
}

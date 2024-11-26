package com.just.demo07;

public class Lecturer extends Teacher{

    public Lecturer(int i, String name) {
        super(i,name);
    }
    public Lecturer(){}
    @Override
    public void work() {
        super.work();
        System.out.println("上课");
    }
}

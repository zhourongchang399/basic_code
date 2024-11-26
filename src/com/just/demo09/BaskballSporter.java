package com.just.demo09;

public class BaskballSporter extends Sporter{
    public BaskballSporter() {
    }

    public BaskballSporter(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("篮球运动员学习打篮球");
    }
}

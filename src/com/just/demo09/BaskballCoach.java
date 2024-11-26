package com.just.demo09;

public class BaskballCoach extends Coach{
    public BaskballCoach() {
    }

    public BaskballCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("篮球教练教打篮球");
    }
}

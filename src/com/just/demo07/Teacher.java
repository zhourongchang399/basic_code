package com.just.demo07;

public class Teacher extends Employee{

    public Teacher(int i, String name) {
        super(i,name);
    }
    public Teacher(){}
    @Override
    public void work() {
        super.work();
        System.out.println("教书育人");
    }
}

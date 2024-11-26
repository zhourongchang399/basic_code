package com.just.demo07;

public class AdminStaff extends Employee{

    public AdminStaff(int i, String name) {
        super(i,name);
    }

    public AdminStaff() {

    }

    @Override
    public void work() {
        super.work();
        System.out.println("行政管理");
    }
}

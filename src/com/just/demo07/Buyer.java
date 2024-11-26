package com.just.demo07;

public class Buyer extends AdminStaff{

    public Buyer(int i, String name) {
        super(i,name);
    }

    public Buyer() {

    }

    @Override
    public void work() {
        super.work();
        System.out.println("采购");
    }
}

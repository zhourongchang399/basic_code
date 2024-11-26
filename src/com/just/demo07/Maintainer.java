package com.just.demo07;

public class Maintainer extends AdminStaff{

    public Maintainer(int i, String name) {
        super(i,name);
    }
    public Maintainer(){}
    @Override
    public void work() {
        super.work();
        System.out.println("维修");
    }
}

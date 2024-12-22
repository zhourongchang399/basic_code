package com.just.demo30;

public class BigStar implements Star{

    String name;
    String age;

    public BigStar(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String sing(String s) {
        System.out.println("唱" + s + "!");
        return "谢谢！";
    }

    @Override
    public String dance(String s) {
        System.out.println("跳" + s + "!");
        return "谢谢！";
    }

}

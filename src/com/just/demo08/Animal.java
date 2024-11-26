package com.just.demo08;

public class Animal {
    private int age;
    private String color;

    public void eat(String something) {
        System.out.println("正在吃" + something);
    }

    public Animal(){}

    public Animal(int age, String color) {
        this.age = age;
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

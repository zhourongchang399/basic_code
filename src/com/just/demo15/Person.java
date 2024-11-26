package com.just.demo15;

public class Person {
    String name;
    int age;
    float high;

    public Person() {
    }

    public Person(String name, int age, float high) {
        this.name = name;
        this.age = age;
        this.high = high;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return high
     */
    public float getHigh() {
        return high;
    }

    /**
     * 设置
     * @param high
     */
    public void setHigh(float high) {
        this.high = high;
    }

    public String toString() {
        return "Person{name = " + name + ", age = " + age + ", high = " + high + "}";
    }
}

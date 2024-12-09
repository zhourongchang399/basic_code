package com.just.demo21;

public class Student {
    String name;
    int age;

    public Student() {
    }

    public Student(String s) {
        String[] values = s.split(",");
        this.name = values[0];
        this.age = Integer.parseInt(values[1]);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public  String concat(){
        return this.name + "-" + this.age;
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

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}

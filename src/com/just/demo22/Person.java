package com.just.demo22;

public class Person {
    String name;
    int age;


    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
    public void setName(String name){
        if(name.length() < 2 || name.length() > 5) {
            throw new RuntimeException();
        }
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
        if(age < 18 || age > 38) {
            throw new RuntimeException();
        }
        this.age = age;
    }

    public String toString() {
        return "person{name = " + name + ", age = " + age + "}";
    }
}

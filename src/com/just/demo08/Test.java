package com.just.demo08;

public class Test {
    public static void main(String[] args) {
        Person person = new Person("老六", 24);
        Dog dog = new Dog();
        dog.setAge(2);
        dog.setColor("黑");
        Cat cat = new Cat();
        cat.setAge(3);
        cat.setColor("蓝");

        person.keepPet(dog, "屎");
        person.keepPet(cat, "毛");
    }
}

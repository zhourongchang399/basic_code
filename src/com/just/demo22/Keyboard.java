package com.just.demo22;

import com.just.demo22.Person;

import java.util.Scanner;

public class Keyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();
        while (true) {
            try {
                System.out.println("Please enter name：");
                person.setName(scanner.nextLine());
                System.out.println("Please enter age：");
                String ageStr = scanner.nextLine();
                person.setAge(Integer.parseInt(ageStr));
            } catch (NumberFormatException e) {
                System.out.println("年龄请输入数字！");
                continue;
            } catch (RuntimeException e) {
                System.out.println("名字或年龄输入错误，请重新输入：");
                continue;
            }
            System.out.println(person);
            break;
        }
    }
}

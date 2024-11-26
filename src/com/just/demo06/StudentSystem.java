package com.just.demo06;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void studentSystem() {
        System.out.println("————————————学生管理系统————————————");
        System.out.println("1:添加学生信息");
        System.out.println("2:删除学生信息");
        System.out.println("3:修改学生信息");
        System.out.println("4:查询学生信息");
        System.out.println("5:退出学生系统");
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentArrayList = new ArrayList<>();
        int count = studentArrayList.size();
        loop : while (true){
            System.out.println("请输入你的操作：");
            int state = sc.nextInt();
            switch (state){
                case 1: {
                    System.out.println("1:添加学生信息");
                    System.out.println("请输入学生ID：");
                    String id = sc.next();
                    System.out.println("请输入学生姓名：");
                    String name = sc.next();
                    System.out.println("请输入学生年龄：");
                    int age = sc.nextInt();
                    System.out.println("请输入学生地址：");
                    String address = sc.next();
                    Student newStudent = new Student(id, name, age, address);
                    studentArrayList = insertStudentInfo(studentArrayList, newStudent);
                    if (studentArrayList.size() == count) {
                        System.out.println("该学生已经存在，请重新操作！");
                    } else {
                        System.out.println("添加学生信息成功！");
                        count = studentArrayList.size();
                    }
                    break;
                }
                case 2: {
                    System.out.println("2:删除学生信息");
                    System.out.println("请输入学生ID：");
                    String id = sc.next();
                    studentArrayList = deleteStudentInfo(studentArrayList, id);
                    if (studentArrayList.size() == count) {
                        System.out.println("该学生不存在，请重新操作！");
                    } else {
                        System.out.println("删除学生信息成功！");
                        count = studentArrayList.size();
                    }
                    break;
                }
                case 3: {
                    System.out.println("3:修改学生信息");
                    System.out.println("请输入学生ID：");
                    String id = sc.next();
                    int index = getIndex(studentArrayList, id);
                    if (index == -1) {
                        System.out.println("该学生不存在，请重新操作！");
                    } else {
                        System.out.println("请输入新信息：");
                        System.out.println("请输入学生姓名：");
                        String name = sc.next();
                        System.out.println("请输入学生年龄：");
                        int age = sc.nextInt();
                        System.out.println("请输入学生地址：");
                        String address = sc.next();
                        Student modifyStudent = new Student(id, name ,age, address);
                        modifyStudentInfo(studentArrayList, modifyStudent, index);
                        System.out.println("修改学生信息成功！");
                    }
                    break;
                }
                case 4: {
                    System.out.println("4:查询学生信息");
                    if (!selectStudentInfo(studentArrayList)) {
                        System.out.println("当前无学生信息，请添加后再查询！");
                    }
                    break;
                }
                case 5: {
                    System.out.println("5:退出学生系统");
                    break loop;
                }
                default:{
                    System.out.println("没有该操作！");
                }
            }
        }
    }

    public static ArrayList<Student> insertStudentInfo(ArrayList<Student> studentArrayList, Student student) {
        if (contains(studentArrayList, student.getId())) {
            return studentArrayList;
        }
        studentArrayList.add(student);
        return studentArrayList;
    }

    public static ArrayList<Student> deleteStudentInfo(ArrayList<Student> studentArrayList, String id) {
        int index = getIndex(studentArrayList, id);
        if (index == -1) {
            return studentArrayList;
        }
        studentArrayList.remove(index);
        return studentArrayList;
    }

    public static void modifyStudentInfo(ArrayList<Student> studentArrayList, Student student, int index) {
        studentArrayList.get(index).setName(student.getName());
        studentArrayList.get(index).setAge(student.getAge());
        studentArrayList.get(index).setAddress(student.getAddress());
    }

    public static boolean selectStudentInfo(ArrayList<Student> studentArrayList) {
        if (studentArrayList.size() != 0) {
            for (int i = 0; i < studentArrayList.size(); i++) {
                System.out.println(studentArrayList.get(i).toString());
            }
            return true;
        }
        return false;
    }

    public static boolean contains(ArrayList<Student> studentArrayList, String id){
        return getIndex(studentArrayList, id) == -1 ? false : true;
    }

    public static int getIndex(ArrayList<Student> studentArrayList, String id) {
        for (int i = 0; i < studentArrayList.size(); i++) {
            Student student = studentArrayList.get(i);
            if (student.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}

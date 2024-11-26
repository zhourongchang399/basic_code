package com.just.demo05;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("创建第一个用户对象：");
            System.out.println("请输入用户名：");
            String username = sc.next();
            System.out.println("请输入密码：");
            String password = sc.next();
            User user = new User(i, username, password);
            list.add(user);
        }

        while (true) {
            System.out.println("请输入您要检索的的用户ID：");
            int index = sc.nextInt();
            int listIndex = searchUserInfo(list, index);
            if (listIndex == -1){
                System.out.println("检索不到该用户！");
            } else {
                System.out.println(list.get(listIndex).toString());
                break;
            }
        }


    }

    public static int searchUserInfo(ArrayList<User> users, int id) {
        for (int i = 0; i < users.size(); i++) {
            User user =  users.get(i);
            if (user.getId() == id) {
                return i;
            }
        }
        return -1;
    }
}

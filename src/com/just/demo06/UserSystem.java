package com.just.demo06;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UserSystem {
    public static void userSystem() {
        System.out.println("————————————登录系统————————————");
        Scanner sc = new Scanner(System.in);
        ArrayList<User> userArrayList = new ArrayList<>();
        User user = new User("admin","123456","441900202410181234","13729921390");
        userArrayList.add(user);
        int size = userArrayList.size();
        loop : while (true) {
            System.out.println("1:登录");
            System.out.println("2:注册");
            System.out.println("3:忘记密码");
            System.out.println("4:退出系统");
            System.out.println("请输入操作：");
            int state = sc.nextInt();
            switch (state) {
                case 1: {
                    System.out.println("1:登录");
                    int chance = 3;
                    int count = 0;
                    for (int i = 0; i < chance; i++) {
                        System.out.println("请输入用户名：");
                        String username = sc.next();
                        System.out.println("请输入密码：");
                        String password = sc.next();
                        while (true) {
                            String code = generateVerificationCode(5);
                            System.out.printf("请输入验证码(%s)：", code);
                            String verificationCode = sc.next();
                            if (code.equalsIgnoreCase(verificationCode)){
                                break;
                            } else {
                                System.out.println("验证码输入错误，请重新输入！");
                            }
                        }

                        User loginUser = new User(username, password, null, null);
                        if (!checkUser(userArrayList, loginUser)) {
                            count++;
                            if (chance - count > 0)
                                System.out.printf("用户名或密码输入错误，请重新输入(还剩%s次机会)！", chance - count);
                            else
                                System.out.println("账号已被锁定，请联系管理员！");
                            continue;
                        } else {
                            System.out.println("登录成功！");
                            StudentSystem ss = new StudentSystem();
                            ss.studentSystem();
                            break loop;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("2:注册");
                    System.out.println("请输入用户名：");
                    String username = sc.next();
                    System.out.println("请输入密码：");
                    String password = sc.next();
                    System.out.println("请再次输入密码：");
                    String doublePassword = sc.next();
                    System.out.println("请输入身份证号码：");
                    String idCard = sc.next();
                    System.out.println("请输入手机号码：");
                    String phoneNumber = sc.next();
                    User newUser = new User(username, password, idCard, phoneNumber);
                    userArrayList = register(userArrayList, newUser, doublePassword);
                    if (userArrayList.size() == size) {
                        System.out.println("注册信息错误，请重新注册！");
                    } else {
                        System.out.println("注册成功！");
                    }
                    break;
                }
                case 3: {
                    System.out.println("3:忘记密码");
                    System.out.println("请输入用户名！");
                    String username = sc.next();
                    if (contains(userArrayList, username)) {
                        System.out.println("请输入身份证号码！");
                        String idCard = sc.next();
                        System.out.println("请输入手机号码！");
                        String phoneNumber = sc.next();
                        User modifyUser = new User(username, null, idCard, phoneNumber);
                        if (matchUser(userArrayList, modifyUser)) {
                            while (true) {
                                System.out.println("请输入修改的密码");
                                String password = sc.next();
                                System.out.println("请再次输入修改的密码");
                                String doublePassword = sc.next();
                                if (password.equals(doublePassword)) {
                                    int index = getIndex(userArrayList, username);
                                    userArrayList.get(index).setPassword(password);
                                    break;
                                } else {
                                    System.out.println("两次密码不一致，请重新输入！");
                                }
                            }
                        } else {
                            System.out.println("账号信息不匹配，修改失败！");
                        }

                    } else {
                        System.out.println("该用户未注册！");
                    }
                    break;
                }
                case 4: {
                    System.out.println("4:退出系统");
                    break loop;
                }
                default:{
                    System.out.println("输入错误，请重新输入！");
                }
            }
        }
    }

    public static boolean matchUser(ArrayList<User> userArrayList, User user) {
        int index = getIndex(userArrayList, user.getUsername());
        User modifyUser = userArrayList.get(index);
        if (!(modifyUser.getPhoneNumber().equals(user.getPhoneNumber()) && modifyUser.getIdCard().equals(user.getIdCard()))) {
            return false;
        }
        return true;
    }

    public static boolean checkUser(ArrayList<User> userArrayList, User user){
        for (int i = 0; i < userArrayList.size(); i++) {
            User currentUser = userArrayList.get(i);
            if (currentUser.getUsername().equals(user.getUsername()) && currentUser.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }

    public static String generateVerificationCode(int length){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                sb.append((char)('0' + random.nextInt(10)));
            } else {
                sb.append((char)('a' + random.nextInt(26)));
            }
        }

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(length);
            String temp = sb.charAt(i) + "";
            sb.replace(i, i + 1, sb.charAt(index) + "");
            sb.replace(index, index + 1, temp);
        }

        return sb.toString();
    }

    public static ArrayList<User> register(ArrayList<User> userArrayList, User user, String doublePassword){
        if (!checkUsername(userArrayList, user.getUsername())){
            return userArrayList;
        }

        if (!checkPassword(user, doublePassword)){
            return userArrayList;
        }

        if (!checkIdCard(user.getIdCard())) {
            return userArrayList;
        }

        if (!checkPhoneNumber(user.getPhoneNumber())) {
            return userArrayList;
        }

        userArrayList.add(user);

        return userArrayList;
    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11){
            return false;
        }

        if (phoneNumber.substring(0,1).equals("0")){
            return false;
        }

        char[] charPhoneNumber = phoneNumber.toCharArray();
        for (int i = 0; i < charPhoneNumber.length; i++) {
            if (charPhoneNumber[i] < '0' || charPhoneNumber[i] > '9'){
                return false;
            }
        }

        return true;
    }

    public static boolean checkPassword(User user, String doublePassword) {
        if (!user.getPassword().equals(doublePassword)){
            return false;
        }
        return true;
    }

    public static boolean checkIdCard(String idCard) {
        if (idCard.length() != 18) {
            return false;
        }

        if (idCard.substring(0,1).equals("0")){
            return false;
        }

        char[] charIdCard = idCard.toCharArray();
        for (int i = 0; i < charIdCard.length; i++) {
            if (i < charIdCard.length - 1 && (charIdCard[i] < '0' || charIdCard[i] > '9')) {
                return false;
            } else if(i == charIdCard.length && !((charIdCard[i] > '0' && charIdCard[i] < '9') || charIdCard[i] == 'x' || charIdCard[i] == 'X')) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkUsername(ArrayList<User> userArrayList, String username) {
        if (contains(userArrayList, username)){
            return false;
        }

        if (username.length() < 3 || username.length() > 15) {
            return false;
        }

        char[] charUsername = username.toCharArray();
        int count = 0;
        for (int i = 0; i < charUsername.length; i++) {
            if (charUsername[i] >= '0' && charUsername[i] <= '9'){
                count++;
            }
        }
        if (count == charUsername.length){
            return false;
        }

        return true;
    }

    public static boolean contains(ArrayList<User> userArrayList, String username) {
        return getIndex(userArrayList, username) == -1 ? false : true;
    }

    public static int getIndex(ArrayList<User> userArrayList, String username){
        for (int i = 0; i < userArrayList.size(); i++) {
            User user = userArrayList.get(i);
            if (user.getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }
}

package com.just.demo02;

public class GameTest {

    public static void main(String[] args) {

        GameRole role_01 = new GameRole("伍六七", 100);
        GameRole role_02 = new GameRole("梅小姐", 100);


        while(true){

            role_01.attract(role_02);
            if (role_02.getBlood() <= 0) {
                System.out.println(role_02.name + "被" + role_01.name + "打败了！");
                break;
            }

            role_02.attract(role_01);
            if (role_01.getBlood() <= 0) {
                System.out.println(role_01.name + "被" + role_02.name + "打败了！");
                break;
            }

        }

    }

}

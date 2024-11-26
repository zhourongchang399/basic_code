package com.just.demo02;

import java.util.Random;

public class GameRole {

    String name;
    int blood;

    public GameRole(String name, int blood) {
        this.name = name;
        this.blood = blood;
    }

    public  GameRole() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void attract(GameRole role) {
        Random random = new Random();
        int power = random.nextInt(100);
        System.out.println(this.name + "攻击了" + role.name + ", 并造成了" + power + "点伤害！");
        role.setBlood(role.getBlood() - power);
    }

}

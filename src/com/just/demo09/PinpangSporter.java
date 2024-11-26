package com.just.demo09;

public class PinpangSporter extends Sporter implements SpeakEnglish{
    public PinpangSporter() {
    }

    public PinpangSporter(String name, int age) {
        super(name, age);
    }

    @Override
    public void speakEnglish() {
        System.out.println("乒乓球运动员说英语");
    }

    @Override
    public void study() {
        System.out.println("乒乓球运动员学习打乒乓球");
    }
}

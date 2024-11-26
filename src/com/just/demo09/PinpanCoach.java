package com.just.demo09;

public class PinpanCoach extends Coach implements SpeakEnglish{
    public PinpanCoach() {
    }

    public PinpanCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("乒乓球教练教打乒乓球");
    }

    @Override
    public void speakEnglish() {
        System.out.println("乒乓球教练说英语");
    }
}

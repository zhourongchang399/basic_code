package com.just.demo09;

public class Test {

    public static void main(String[] args) {
        BaskballSporter baskballSporter = new BaskballSporter("易建联", 40);
        baskballSporter.study();

        PinpangSporter pinpangSporter = new PinpangSporter();
        pinpangSporter.setAge(30);
        pinpangSporter.setName("张继科");
        pinpangSporter.study();
        pinpangSporter.speakEnglish();
    }

}

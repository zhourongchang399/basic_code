package com.just.demo13;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Exercise03 {
    public static void main(String[] args) throws ParseException {

        Date time = new Date();
        String birthday = "1999年4月10日 08:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = simpleDateFormat.parse(birthday);
        long diff = time.getTime() - date.getTime();
        System.out.println(diff / 1000 / 60 / 60 / 24);

        LocalDate localDate = LocalDate.of(2000, 1, 1);
        LocalDate nowDate = LocalDate.now();
        long days = ChronoUnit.DAYS.between(localDate, nowDate);
        System.out.println(days);

    }
}

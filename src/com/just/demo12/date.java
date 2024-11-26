package com.just.demo12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class date {
    public static void main(String[] args) throws ParseException {
        String date = "2024-10-23 23:47:24";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = simpleDateFormat.parse(date);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println(simpleDateFormat1.format(date1));

        String date2 = "2024年10月23日 0:01:00";
        String date3 = "2024年10月23日 0:11:00";
        String date4 = "2024年10月23日 0:10:00";

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date time1 = simpleDateFormat2.parse(date2);
        Date time2 = simpleDateFormat2.parse(date3);
        Date endTime = simpleDateFormat2.parse(date4);
        System.out.println(time1.getTime() < endTime.getTime());
        System.out.println(time2.getTime() < endTime.getTime());
    }
}

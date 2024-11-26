package com.just.demo13;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Exercise04 {
    public static void main(String[] args) {
        for (int i = 1970; i < 2025; i++) {
            if (runYear(i)) {
                System.out.printf("%s是闰年\n", i);
            }
        }
    }

    public static boolean runYear(int i) {
        LocalDate localDate = LocalDate.of(i, 1,1);
        LocalDate localDate1 = LocalDate.of(i + 1, 1, 1);
        LocalDate localDate2 = LocalDate.of(i, 2,1);
        LocalDate localDate3 = LocalDate.of(i, 3, 1);
        if (ChronoUnit.DAYS.between(localDate2, localDate3) == 29){
            return true;
        }
        if (ChronoUnit.DAYS.between(localDate, localDate1) == 366){
            return true;
        }
        return false;
    }
}

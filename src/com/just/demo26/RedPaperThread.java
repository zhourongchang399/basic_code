package com.just.demo26;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class RedPaperThread extends Thread {

    static BigDecimal money = BigDecimal.valueOf(100);
    static int count = 3;
    final static BigDecimal minMoney = BigDecimal.valueOf(0.01);

    @Override
    public void run() {
    synchronized (RedPaperThread.class) {
        if (count == 0) {
            System.out.println(getName() + "没抢到红包！");
        } else if (count == 1){
            System.out.println(getName() + "抢到了" + money + "元红包！");
            count--;
        } else {
            BigDecimal price;
            Random random = new Random();
            BigDecimal bounds = money.subtract(BigDecimal.valueOf(count - 1).multiply(minMoney));
            int i = random.nextInt(bounds.intValue());
            BigDecimal j = BigDecimal.valueOf(random.nextDouble());
            while (j.compareTo(bounds.subtract(BigDecimal.valueOf(i))) > 0) {
                j = BigDecimal.valueOf(random.nextDouble());
            }
            price = j.add(BigDecimal.valueOf(i));
            price = price.setScale(2, RoundingMode.HALF_UP);
            System.out.println(getName() + "抢到了" + price + "元红包！");
            money = money.subtract(price);
            count--;
        }
    }

    }
}

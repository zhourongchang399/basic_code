package com.just.demo25;

import cn.hutool.Hutool;
import cn.hutool.core.io.FileUtil;

import javax.print.DocFlavor;
import javax.rmi.CORBA.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WeightedRollCall2 {
    public static void main(String[] args) {
        // import data
        File file = new File("C:\\Users\\49744\\Documents\\basic_code\\src\\com\\just\\demo25\\person.txt");
        List<String> strings = FileUtil.readLines(file, "UTF-8");
        ArrayList<Double> weights = new ArrayList<>();
        for (String string : strings) {
            String[] split = string.split("-");
            weights.add(Double.parseDouble(split[3]));
        }

        // set domain for every person
        ArrayList<Double> domains = new ArrayList<>();
        domains.add(0.0);
        for (int i = 0; i < weights.size(); i++) {
            Double weight = weights.get(i);
            Double domain = weight / (double) strings.size();
            domains.add(domains.get(i) + domain);
        }

        // random select person
        double v = Math.random();
        while (v > domains.get(domains.size() - 1)) {
            v = Math.random();
        }
        System.out.println(v);
        int i = -Collections.binarySearch(domains, v) - 1;
        System.out.println(i);
        weights.set(i, weights.get(i) / 2.0);
        System.out.println(strings.get(i));

        // save data
        String[] split1 = strings.get(i).split("-");
        strings.set(i, split1[0] + "-" + split1[1] + "-" + split1[2] + "-" + weights.get(i));
        FileUtil.writeLines(strings, file, "UTF-8");

    }
}

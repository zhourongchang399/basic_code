package com.just.demo13;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int total = 0;
        while (true) {
            if (total > 200){
                break;
            }
            String input = scanner.nextLine();
            int i = Integer.parseInt(input);
            if (i < 1 || i > 100) {
                continue;
            }
            list.add(i);
            total += i;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

package com.just.demo01;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World !");
        int[] list = {1,5,76,-32,5,0,123,5,6,-123,54,65463,-123,564,2423};
        Sort sort = new Sort();
        sort.fastSort(list, 0, list.length - 1);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]);
            System.out.print(',');
        }
    }
}

package com.just.demo20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class dataFilter {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 1,2,3,4,5,6,7,8,9,10);
        List<Integer> arrayList1 = arrayList.stream().filter(s -> s % 2 == 0).collect(Collectors.toList());
        Iterator<Integer> iterator = arrayList1.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

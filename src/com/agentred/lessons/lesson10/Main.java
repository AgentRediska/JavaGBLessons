package com.agentred.lessons.lesson10;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
    }

    static void task1() {
        List<String> list = new LinkedList<>();
        list.add("раз");
        list.add("два");
        list.add("три");
        list.add("раз");
        list.add("раз");
        list.add("два");
        list.add("семь");
        list.add("восемь");
        list.add("сто");

        sort(list);
    }

    static void sort(List<String> list) {
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (String s : list) {
            if (sortedMap.containsKey(s))
                sortedMap.put(s, sortedMap.get(s) + 1);
            else
                sortedMap.put(s, 1);

        }
        System.out.println(sortedMap);
    }

    static void task2() {

        Directory directory = new Directory();
        directory.add("antonyan", "8999123321");
        directory.add("antonyan", "8912155326");
        directory.add("bobov", "8917155552");
        directory.add("bobov", "8913455672");
        directory.add("antonyan", "899999999");
        directory.add("igoryan", "899111111");
        directory.add("bobov", "89923231999");
        directory.add("smetanov", "8888123113");
        directory.add("igoryan", "8324325234");

        System.out.println(directory.get("antonyan"));
        System.out.println(directory.get("igoryan"));
        System.out.println(directory.get("bobov"));
        System.out.println(directory.get("smetanov"));
    }
}

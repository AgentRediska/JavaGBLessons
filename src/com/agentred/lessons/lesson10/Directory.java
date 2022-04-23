package com.agentred.lessons.lesson10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directory {

    private final Map<String, List<String>> map = new HashMap<>();

    public List<String> get(String surname) {
        return map.get(surname);
    }

    public void add(String surname, String phone) {
        List<String> phoneList;
        if(map.containsKey(surname)) {
            phoneList = map.get(surname);
        } else {
            phoneList = new ArrayList<>();
        }
        phoneList.add(phone);
        map.put(surname, phoneList);
    }
}

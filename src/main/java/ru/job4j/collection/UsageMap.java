package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("nizamova@mail.ru", "Низамова Мария Анатольевна");
        map.put("nizamov@mail.ru","Низамов Тимур Ильдарович");
        map.put("nizamov@mail.ru","Низамов Григорий Тимурович");
        map.put("saharova@maol.ru", "Сахарова Екатерина Александровна");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}

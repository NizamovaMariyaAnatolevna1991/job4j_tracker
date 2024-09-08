package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("Ivan");
        student1.setGroup("BMT");
        student1.setEnterDate(new Date());
        System.out.println(student1.getName() + " " + student1.getGroup() + " " + student1.getEnterDate());
    }
}

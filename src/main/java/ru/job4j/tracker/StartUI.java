package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item iterm1 = new Item(1, "Ben", LocalDateTime.now());
        iterm1.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String dateCreatedFormat = iterm1.getCreated().format(formatter);
        System.out.println(dateCreatedFormat);
    }
}

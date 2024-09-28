package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Взлет, полет на высоте 6000 м");
    }
}

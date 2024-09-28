package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Тут-тут. Колеса по рельсам застучали.");
    }
}

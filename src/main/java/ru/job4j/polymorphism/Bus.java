package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Автобус движется");
    }

    @Override
    public void passengers(int count) {
        int passengers = count - 2;
        System.out.println("В автобусе" + passengers + "пассажиров");
    }

    @Override
    public int refuel(int fuel) {
        int cost = fuel * 50;
        return cost;
    }
}

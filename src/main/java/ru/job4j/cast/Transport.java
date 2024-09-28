package ru.job4j.cast;

public class Transport {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();

        Vehicle[] vehicles = new Vehicle[]{airplane, train, bus};
        for (Vehicle obj : vehicles) {
            obj.move();
        }
    }
}


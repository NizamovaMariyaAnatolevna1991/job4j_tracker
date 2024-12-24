package ru.job4j.queue;

import java.util.LinkedList;
import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String lastHappyCustormer = "";
        for (int i = 0; i < count; i++) {
            lastHappyCustormer = queue.poll().name();
        }
        return lastHappyCustormer;
    }

    public String getFirstUpsetCustomer() {
        String firstUpsetCustomer = "";
        for (int i = 0; i <= count; i++) {
            if (i == count) {
            firstUpsetCustomer = queue.peek().name();
            break;
        }
        queue.poll();
        }
        return firstUpsetCustomer;
    }
}
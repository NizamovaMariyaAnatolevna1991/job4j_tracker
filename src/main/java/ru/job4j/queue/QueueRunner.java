package ru.job4j.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueRunner {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("first");
        queue.add("second");
        queue.add("third");
        queue.poll();

        for (String string : queue) {
            System.out.println(string);
        }
    }
}
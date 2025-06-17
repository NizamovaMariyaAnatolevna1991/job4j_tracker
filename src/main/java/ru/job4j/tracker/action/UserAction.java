package ru.job4j.tracker.action;

import ru.job4j.tracker.SqlTracker;
import ru.job4j.tracker.input.Input;

public interface UserAction {
    String name();

    boolean execute(Input input, SqlTracker tracker);
}

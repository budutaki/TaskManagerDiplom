package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Todos {
    protected List<String> tasks;

    public Todos() {
        this.tasks = new ArrayList<>() {
        };
    }

    public void addTask(String task) {
        if (tasks.contains(task)) {
            return;
        } else
            tasks.add(task);
    }

    public void removeTask(String task) throws RuntimeException {
        if (tasks.contains(task)) {
            tasks.remove(task);
        } else throw new RuntimeException("No such task");
    }

    public String getAllTasks() {
        StringBuilder sb = new StringBuilder();
        Stream<String> ts = tasks.stream()
                .sorted(Comparator.naturalOrder());
        tasks = ts.collect(Collectors.toList());
        for (String task : tasks) {
            sb.append(task + " ");
        }
        return String.valueOf(sb);
    }
}




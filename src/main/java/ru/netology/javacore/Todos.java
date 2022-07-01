package ru.netology.javacore;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Todos {
public List<String> tasks;

    public Todos() {
        this.tasks = new ArrayList<>() {
        };
    }

    public void addTask(String task) {
        tasks.add(task + " ");
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        StringBuilder sb = new StringBuilder();
        Stream <String> ts = tasks.stream()
                .sorted(Comparator.naturalOrder());
                tasks = ts.collect(Collectors.toList());
        for (String task : tasks) {
            sb.append(task + " ");
        }
        return String.valueOf(sb);
    }
    }




























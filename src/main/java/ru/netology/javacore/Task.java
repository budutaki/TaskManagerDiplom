package ru.netology.javacore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
    private final TaskType type;
    private final String task;

    public Task(@JsonProperty ("type") TaskType type, @JsonProperty ("task") String task) {
        this.type = type;
        this.task = task;
    }

    public TaskType getType() {
        return type;
    }

    public String getTask() {
        return task;
    }

    @Override
    public String toString() {
        return "Task{" +
                "type='" + type + '\'' +
                ", task='" + task + '\'' +
                '}';
    }
}

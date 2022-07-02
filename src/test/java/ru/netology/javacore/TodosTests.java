package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTests {

    @Test
    public void addTaskTest() {
        Todos todos = new Todos();
        todos.addTask("A");
        todos.addTask("B");
        todos.addTask("A");
        Assertions.assertTrue(todos.tasks.contains("A") | todos.tasks.contains("B"));
        Assertions.assertEquals(2, todos.tasks.size());
    }

    @Test
    public void removeTaskTest() {
        Todos todos = new Todos();
        todos.addTask("A");
        todos.removeTask("A");
        Assertions.assertFalse(todos.tasks.contains("A") | todos.tasks.contains("B"));
        Assertions.assertThrows(RuntimeException.class, () -> todos.removeTask("B"),
                "No such task");

    }

    @Test
    public void getAllTasksTest() {
        Todos todos = new Todos();
        todos.addTask("C");
        todos.addTask("B");
        todos.addTask("A");
        String result = todos.getAllTasks();
        Assertions.assertTrue(result.startsWith("A"));

    }
}



import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


import org.example.TaskManager;
import org.example.User;
import org.example.Task;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

class TaskManagerTest {
    private TaskManager tm;
    private User user;
    private Task task;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        tm = new TaskManager();
        user = new User();
        user.tasks = new ArrayList<>();
        task = new Task();
        task.title = "TMTask";

        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void smoke_addTask() {
        tm.addTask(user, task);
        assertTrue(user.tasks.contains(task));
    }

    @Test
    void smoke_removeTask() {
        user.tasks.add(task);
        tm.removeTask(user, task);
        assertFalse(user.tasks.contains(task));
    }

    @Test
    void smoke_listAllTasks() {
        user.tasks.add(task);
        tm.listAllTasks(user);
        String printed = out.toString();
        assertTrue(printed.contains("["));          // array‐style toString
        assertTrue(printed.contains(task.title));
    }
}

import org.example.NotificationCenter;
import org.example.User;
import org.example.Task;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class UserTest {
    private User user;
    private Task task;

    @BeforeEach
    void setUp() {
        user = new User();
        user.name = "Carol";
        user.tasks = new ArrayList<>();
        task = new Task();
        task.title = "UTask";
    }

    @Test
    void smoke_addTask() {
        // make sure NotificationCenter won't NPE
        NotificationCenter.notifications = new HashMap<>();

        user.addTask(task);
        assertTrue(user.tasks.contains(task));
        assertTrue(NotificationCenter.notifications.containsKey(user));
    }

    @Test
    void smoke_getAllTasks() {
        user.tasks.add(task);
        List<Task> all = user.getAllTasks();
        assertEquals(1, all.size());
        assertSame(task, all.get(0));
    }

    @Test
    void smoke_hasTask() {
        assertFalse(user.hasTask(task));
        user.tasks.add(task);
        assertTrue(user.hasTask(task));
    }
}

import org.example.NotificationCenter;
import org.example.User;
import org.example.Task;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;



class NotificationCenterTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private User user;
    private Task task;

    @BeforeEach
    void setUp() {
        // reset the static map
        NotificationCenter.notifications = new HashMap<>();
        System.setOut(new PrintStream(out));

        user = new User();
        user.name = "Alice";
        task = new Task();
        task.title = "T1";
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void smoke_notifyUsers() {
        NotificationCenter.notifyUsers(user, task);
        // map contains exactly one entry for our user
        assertEquals(1, NotificationCenter.notifications.size());
        assertTrue(NotificationCenter.notifications.containsKey(user));
        // printed string contains both user name and task title
        String printed = out.toString();
        assertTrue(printed.contains("Alice has been assigned T1"));
    }

    @Test
    void smoke_getNotificationsForUser() {
        // prepare
        NotificationCenter.notifications.put(user, "Alice has been assigned T1");
        NotificationCenter.getNotificationsForUser(user);
        String printed = out.toString();
        assertTrue(printed.contains("Here are the tasks of Alice"));
        assertTrue(printed.contains("Alice has been assigned T1"));
    }
}

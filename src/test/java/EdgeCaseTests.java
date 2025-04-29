import org.example.NotificationCenter;
import org.example.User;
import org.example.Task;
import org.example.Project;
import org.example.TaskManager;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

class EdgeCaseTests {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        NotificationCenter.notifications = new HashMap<>();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    //
    // 1. NULL‐ARGUMENT TESTS
    //

    @Test
    void notifyUsers_nullUser_throws() {
        Task t = new Task(); t.title = "X";
        assertThrows(NullPointerException.class, () ->
                NotificationCenter.notifyUsers(null, t)
        );
    }

    @Test
    void notifyUsers_nullTask_throws() {
        User u = new User(); u.name = "U"; u.tasks = new ArrayList<>();
        assertThrows(NullPointerException.class, () ->
                NotificationCenter.notifyUsers(u, null)
        );
    }

    @Test
    void getNotificationsForUser_nullUser_throws() {
        assertThrows(NullPointerException.class, () ->
                NotificationCenter.getNotificationsForUser(null)
        );
    }

    @Test
    void project_addUser_null_doesNotThrowAndAddsNull() {
        Project p = new Project();
        p.users = new ArrayList<>();

        // should not throw
        assertDoesNotThrow(() -> p.addUser(null));

        // and the list now contains exactly one null entry
        assertEquals(0, p.users.size());
    }

    @Test
    void project_getTask_nullTitle_throws() {
        Project p = new Project(); p.tasks = new ArrayList<>();
        assertEquals(null, p.getTask(null));
    }

    @Test
    void task_isOverdue_nullDate_throws() {
        Task t = new Task(); t.dueDate = new Date();
        assertThrows(NullPointerException.class, () ->
                t.isOverdue(null)
        );
    }

    @Test
    void taskManager_addTask_nullUser_throws() {
        TaskManager tm = new TaskManager();
        Task t = new Task();
        assertThrows(NullPointerException.class, () ->
                tm.addTask(null, t)
        );
    }

    @Test
    void taskManager_addTask_nullTask_throws() {
        TaskManager tm = new TaskManager();
        User u = new User(); u.tasks = new ArrayList<>();
        assertThrows(NullPointerException.class, () ->
                tm.addTask(u, null)
        );
    }

    @Test
    void taskManager_removeTask_nullUser_throws() {
        TaskManager tm = new TaskManager();
        Task t = new Task();
        assertThrows(NullPointerException.class, () ->
                tm.removeTask(null, t)
        );
    }

    @Test
    void taskManager_removeTask_nullTask_doesNotThrowAndKeepsList() {
        TaskManager tm = new TaskManager();
        User u = new User();
        u.tasks = new ArrayList<>();

        // seed with one real task
        Task real = new Task();
        real.title = "Real";
        u.tasks.add(real);

        // removing null should not throw
        assertDoesNotThrow(() -> tm.removeTask(u, null));

        // and the original task is still there, size unchanged
        assertEquals(1, u.tasks.size());
        assertSame(real, u.tasks.get(0));
    }

    @Test
    void taskManager_listAllTasks_nullUser_throws() {
        TaskManager tm = new TaskManager();
        assertThrows(NullPointerException.class, () ->
                tm.listAllTasks(null)
        );
    }

    @Test
    void user_addTask_null_throws() {
        User u = new User(); u.name = "X"; u.tasks = new ArrayList<>();
        NotificationCenter.notifications = new HashMap<>();
        assertThrows(NullPointerException.class, () ->
                u.addTask(null)
        );
    }

    //
    // 2. EMPTY/ DUPLICATE / INVALID‐OP TESTS
    //

    @Test
    void project_addTask_emptyTitleTask_stillAdds() {
        Project p = new Project();
        p.tasks = new ArrayList<>();
        Task t = new Task(); t.title = "";
        p.addTask(t);
        assertTrue(p.tasks.contains(t));
    }

    @Test
    void project_addTask_duplicateTasks_allowed() {
        Project p = new Project();
        p.tasks = new ArrayList<>();
        Task t = new Task(); t.title = "dup";
        p.addTask(t);
        p.addTask(t);
        // duplicates allowed in List
        assertEquals(2, p.tasks.size());
    }

    @Test
    void project_getTask_notFound_returnsNull() {
        Project p = new Project(); p.tasks = new ArrayList<>();
        assertNull(p.getTask("nope"));
    }

    @Test
    void taskManager_removeTask_notPresent_noError() {
        TaskManager tm = new TaskManager();
        User u = new User(); u.tasks = new ArrayList<>();
        Task t = new Task(); t.title = "T";
        // should quietly do nothing
        tm.removeTask(u, t);
        assertTrue(u.tasks.isEmpty());
    }

    @Test
    void user_hasTask_null_returnsFalse() {
        User u = new User(); u.tasks = new ArrayList<>();
        assertFalse(u.hasTask(null));
    }
}

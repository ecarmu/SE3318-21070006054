
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Project;
import org.example.User;
import org.example.Task;
import java.util.*;

class ProjectTest {
    private Project project;
    private User u1;
    private Task t1;

    @BeforeEach
    void setUp() {
        project = new Project();
        project.users = new ArrayList<>();
        project.tasks = new ArrayList<>();

        u1 = new User();
        u1.name = "Bob";
        t1 = new Task();
        t1.title = "TaskX";
    }

    @Test
    void smoke_addUser() {
        project.addUser(u1);
        assertTrue(project.users.contains(u1));
    }

    @Test
    void smoke_addTask() {
        project.addTask(t1);
        assertTrue(project.tasks.contains(t1));
    }

    @Test
    void smoke_getTask_found() {
        project.tasks.add(t1);
        Task found = project.getTask("TaskX");
        assertSame(t1, found);
    }

    @Test
    void smoke_getTask_notFound() {
        assertNull(project.getTask("DoesNotExist"));
    }
}

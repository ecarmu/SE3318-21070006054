
import org.example.Task;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

class TaskTest {
    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
        // due yesterday
        task.dueDate = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        task.completionStatus = false;
    }

    @Test
    void smoke_isOverdue_true() {
        Date now = new Date();
        assertTrue(task.isOverdue(now));
    }

    @Test
    void smoke_isOverdue_false() {
        // date before dueDate
        Date before = new Date(task.dueDate.getTime() - TimeUnit.DAYS.toMillis(1));
        assertFalse(task.isOverdue(before));
    }

    @Test
    void smoke_setComplete() {
        task.setComplete();
        assertTrue(task.completionStatus);
    }
}

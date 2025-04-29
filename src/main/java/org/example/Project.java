package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project {
    public List<Task> tasks;
    public List<User> users;

    public Project(List<Task> tasks, List<User> users) {
        this.tasks = tasks;
        this.users = users;
    }

    public Project() {
        tasks = new ArrayList<>();
        users = new ArrayList<>();
    }

    /**
     * @param u: User that will be added
     * _requires_: u must not be "null"
     * _effect_: user will be added to the users list
     */
    public void addUser(User u){
        if (Objects.equals(u, null))
            return;
        users.add(u);
    }

    /**
     * @param t: Task that will be added
     * _requires_: t must not be "null"
     * _effect_: task will be added to the tasks list
     */
    public void addTask(Task t){
        tasks.add(t);
    }

    /**
     * @param title: title of the task that is searched
     * _requires_: title must not be "null"
     * _effect_: if a task is found with the given title that task will returned if not a "null" is returned
     */
    public Task getTask(String title){
        return tasks.stream()
                .filter(task -> task.title.equals(title))
                .findFirst()
                .orElse(null);
    }
}

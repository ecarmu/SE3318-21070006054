package org.example;

import java.util.List;

public class User {
    public String name;
    String email;

    public List<Task> tasks;

    /**
     * @param t: Task that will be added
     * _requires_: t must not be "null"
     * _effect_: task will be added to the users and the user will get notified
     */
    public void addTask(Task t){
        tasks.add(t);
        NotificationCenter.notifyUsers(this, t);
    }

    /**
     * _requires_: nothing
     * _effect_: all tasks will get returned
     */
    public List<Task> getAllTasks(){
        return tasks;
    }

    /**
     * @param t: Task that will be added
     * _requires_: t must not be "null"
     * _effect_: returns true if tasks list contains the task, false if not
     */
    public boolean hasTask(Task t){
        return tasks.contains(t);
    }
}

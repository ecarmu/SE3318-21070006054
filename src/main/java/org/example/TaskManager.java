package org.example;

import java.util.List;

public class TaskManager {


    /**
     * @param u: User that will be added
     * @param t: Task that will be added
     * _requires_: u and t must not be "null"
     * _effect_: task will be added to the users
     */
    public void addTask(User u, Task t){
        u.addTask(t);
    }

    /**
     * @param u: User that will be added
     * @param t: Task that will be added
     * _requires_: u and t must not be "null"
     * _effect_: task will be removed from user
     */
    public void removeTask(User u, Task t){
        if(t != null)
            u.tasks.remove(t);
    }

    /**
     * @param u: User that will be added
     * _requires_: u must not be "null"
     * _effect_: all of the tasks of the given user will be printed
     */
    public void listAllTasks(User u){
        List<Task> tasks = u.getAllTasks();
        System.out.println(tasks.toString());
    }
}

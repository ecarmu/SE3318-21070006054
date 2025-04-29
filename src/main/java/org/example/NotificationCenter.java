package org.example;

import java.util.HashMap;
import java.util.Map;

public class NotificationCenter {

    public static Map<User, String> notifications = new HashMap<>();

    /**
     * @param u: user that will get notified
     * @param t: task that will be used when notifying the user
     * _requires_: u and t must not be "null"
     * _effects: outputs a notification and saves that notification in notifications
     */
    public static void notifyUsers(User u, Task t){
        String notification = u.name + " has been assigned " + t.title;
        System.out.println(notification);
        notifications.put(u, notification);
    }

    public NotificationCenter() {
        notifications = new HashMap<>();
    }

    /**
     * @param u: user whom their notifications get retrieved
     * _requires_: u must not be "null"
     * _effect_: outputs the notifications of the u
     */
    public static void getNotificationsForUser(User u){
        System.out.println("Here are the tasks of " + u.name);
        notifications.entrySet().stream()
                .filter(entry -> entry.getKey().equals(u))
                .forEach(entry -> System.out.println(entry.getValue()));
    }
}

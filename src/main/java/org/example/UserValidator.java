package org.example;

public class UserValidator {

    public boolean validateUser(String name, int age, String email) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Name is missing");
            return false;
        }

        if (name.length() < 2) {
            System.out.println("Name too short");
            return false;
        }

        if (age < 0 || age > 150) {
            System.out.println("Age is out of range");
            return false;
        }

        if (email == null || !email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            System.out.println("Email is invalid");
            return false;
        }

        return true;
    }
}

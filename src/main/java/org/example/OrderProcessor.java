package org.example;

import java.util.List;
import java.util.Objects;

public class OrderProcessor {

    public void processOrder(String orderId, List<String> items) {
        if (orderId == null || orderId.isEmpty()) {
            System.out.println("Invalid order ID");
            return; // Stop processing invalid order ID
        }

        if (items == null || items.isEmpty()) {
            System.out.println("No items to process for order: " + orderId);
            return; // Stop processing if no items
        }

        if (orderId.length() > 5) {
            System.out.println("Processing complex order: " + orderId);
        } else {
            System.out.println("Processing order: " + orderId);
        }

        for (String item : items) {
            if (item == null || item.isEmpty()) {
                System.out.println("Skipping empty or null item");
                continue;
            }

            // A simple validation that the item should contain only letters and digits (example)
            if (item.matches("[a-zA-Z0-9]+")) {
                System.out.println("Valid item: " + item);
            } else {
                System.out.println("Skipping unknown item: " + item);
            }
        }
    }
}

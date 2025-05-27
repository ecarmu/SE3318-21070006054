package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        processor.processOrder("12345", Arrays.asList("item1", "item2", null));

        UserValidator validator = new UserValidator();
        validator.validateUser("A", -5, null);

        PaymentService paymentService = new PaymentService();
        paymentService.processPayment("", -250.00, "USD");
    }
}
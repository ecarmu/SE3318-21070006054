package org.example;

public class PaymentService {

    public boolean processPayment(String cardNumber, double amount, String currency) {
        if (cardNumber == null || cardNumber.isEmpty()) {
            System.out.println("Card number is missing");
            return false;
        }

        if (currency == null || currency.isEmpty()) {
            System.out.println("Currency is missing");
            return false;
        }

        if (amount <= 0) {
            System.out.println("Amount must be positive");
            return false;
        }

        if (cardNumber.length() != 16) {
            System.out.println("Invalid card number length");
            return false;
        }

        if (cardNumber.startsWith("4")) {
            if ("USD".equals(currency)) {
                System.out.println("Processing Visa USD payment");
            } else {
                System.out.println("Visa payment in other currency: " + currency);
            }
        } else {
            System.out.println("Non-Visa card detected");
        }

        // Assume payment succeeded after checks
        return true;
    }
}

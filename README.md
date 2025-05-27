OrderProcessor.java
Problem: No null check on orderId and items → can cause crashes.
Fix: Check if orderId or items is null or empty before processing; exit early if invalid.

Problem: Item validation uses item.contains("item") — too simple and unreliable.
Fix: Use a better validation, e.g., check if item is non-empty and matches expected format.

PaymentService.java
Problem: No null check on cardNumber and currency → risks exceptions.
Fix: Validate cardNumber and currency for null/empty before processing.

Problem: Card length checked after other logic; invalid length allowed.
Fix: Check card number length first; if invalid, stop processing.

Problem: Amount validation done too late.
Fix: Validate amount is positive before anything else.

Problem: No return value indicating success or failure.
Fix: Return boolean to signal if payment succeeded.

UserValidator.java
Problem: Always returns true, even if invalid input.
Fix: Return false immediately on invalid input.

Problem: No null check on name or email.
Fix: Add null and empty checks for name and email.

Problem: Email validation only checks for '@', which is too weak.
Fix: Improve email validation (e.g., check @ isn’t first/last character).

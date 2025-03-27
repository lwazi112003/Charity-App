package za.ac.cput.util;

import java.util.UUID;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class Helper {
    // Generate unique ID
    public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    // Email validation
    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    // Phone number validation
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) return false;
        // Simple regex for valid phone numbers
        String phoneRegex = "^\\+?\\d{10,14}$";
        return Pattern.compile(phoneRegex).matcher(phoneNumber).matches();
    }

    // Get current date
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    // Validate not null or empty
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
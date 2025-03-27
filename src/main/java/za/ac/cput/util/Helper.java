package za.ac.cput.util;

import java.time.LocalDate;
import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isValidDouble(double value) {
        return value > 0;
    }

    public static boolean isDateValid(LocalDate date) {
        return date != null && !date.isAfter(LocalDate.now());
    }
}

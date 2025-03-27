package za.ac.cput.Factory;

import org.charity.domain.User;
import org.charity.util.Helper;
import java.time.LocalDate;

public class UserFactory {
    // Core method to create a user with comprehensive validation
    public static User createUser(
            String firstName,
            String lastName,
            String email,
            String phoneNumber,
            User.UserRole role
    ) {
        // Validate first name
        if (Helper.isNullOrEmpty(firstName)) {
            throw new IllegalArgumentException("First name cannot be empty");
        }

        // Validate last name
        if (Helper.isNullOrEmpty(lastName)) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }

        // Validate email
        if (!Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        // Validate phone number
        if (!Helper.isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number format");
        }

        // Validate role
        if (role == null) {
            throw new IllegalArgumentException("User role must be specified");
        }

        // Create user using Builder pattern
        return new User.Builder()
                .userId(Helper.generateUniqueId())
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phoneNumber(phoneNumber)
                .registrationDate(LocalDate.now())
                .role(role)
                .build();
    }

    // Create a default donor user
    public static User createDefaultDonor() {
        return createUser(
                "John",
                "Doe",
                "johndoe@charity.org",
                "+1234567890",
                User.UserRole.DONOR
        );
    }

    // Create a default beneficiary user
    public static User createDefaultBeneficiary() {
        return createUser(
                "Jane",
                "Smith",
                "janesmith@charity.org",
                "+0987654321",
                User.UserRole.BENEFICIARY
        );
    }

    // Create a default event organizer user
    public static User createDefaultEventOrganizer() {
        return createUser(
                "Event",
                "Coordinator",
                "eventcoord@charity.org",
                "+1122334455",
                User.UserRole.EVENT_ORGANIZER
        );
    }

    // Method to create a user with optional parameters
    public static User createUserWithOptionals(
            String firstName,
            String lastName,
            String email,
            String phoneNumber,
            User.UserRole role,
            String userId,  // Optional
            LocalDate registrationDate  // Optional
    ) {
        // Use provided userId or generate a new one
        String finalUserId = (userId != null) ? userId : Helper.generateUniqueId();

        // Use provided registration date or current date
        LocalDate finalRegistrationDate = (registrationDate != null)
                ? registrationDate
                : LocalDate.now();

        // Validate required fields
        if (Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) ||
                !Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid user details");
        }

        // Create user with optional parameters
        return new User.Builder()
                .userId(finalUserId)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phoneNumber(phoneNumber)
                .registrationDate(finalRegistrationDate)
                .role(role)
                .build();
    }

    // Specific method for admin-created users
    public static User createAdminCreatedUser(
            String firstName,
            String lastName,
            String email,
            User.UserRole role
    ) {
        // Phone number is optional for admin-created users
        return createUser(
                firstName,
                lastName,
                email,
                "+000000000",  // Default placeholder
                role
        );
    }
}
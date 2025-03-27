package za.ac.cput.Domain;

import java.time.LocalDate;

public class Donation {
    private final String userId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final LocalDate registrationDate;
    private final UserRole role;

    public Donation(Builder builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.registrationDate = builder.registrationDate;
        this.role = builder.role;
    }

    // Getters
    public String getUserId() { return userId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public LocalDate getRegistrationDate() { return registrationDate; }
    public UserRole getRole() { return role; }

    public enum UserRole {
        ADMIN, DONOR, BENEFICIARY, EVENT_ORGANIZER
    }

    // Builder Pattern
    public static class Builder {
        private String userId;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private LocalDate registrationDate;
        private UserRole role;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder registrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder role(UserRole role) {
            this.role = role;
            return this;
        }

        public Donation build() {
            // Add validation logic here
            if (userId == null || firstName == null || lastName == null || email == null) {
                throw new IllegalStateException("User requires userId, firstName, lastName, and email");
            }
            return new Donation(this);
        }
    }
}
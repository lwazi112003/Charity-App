package za.ac.cput.Domain;

import java.util.Objects;

public class User {
    private final String userId;
    private final String firstName;
    private final String lastName;
    private final String email;

    // Private constructor to be used by the Builder
    private User(Builder builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    // Builder class
    public static class Builder {
        private String userId;
        private String firstName;
        private String lastName;
        private String email;

        // Constructor
        public Builder() {}

        // Builder methods with return type Builder for method chaining
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

        // Build method to create User instance
        public User build() {
            // Add validation if needed
            Objects.requireNonNull(userId, "User ID cannot be null");
            Objects.requireNonNull(firstName, "First name cannot be null");
            Objects.requireNonNull(lastName, "Last name cannot be null");
            Objects.requireNonNull(email, "Email cannot be null");

            return new User(this);
        }
    }

    // equals, hashCode, and toString methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
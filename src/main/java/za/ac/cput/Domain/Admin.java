package za.ac.cput.Domain;

import java.util.Objects;

public class Admin {
    private final String adminId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String department;

    // Private constructor to be used by the Builder
    private Admin(Builder builder) {
        this.adminId = builder.adminId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.department = builder.department;
    }

    // Getters
    public String getAdminId() {
        return adminId;
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

    public String getDepartment() {
        return department;
    }

    // Builder class
    public static class Builder {
        private String adminId;
        private String firstName;
        private String lastName;
        private String email;
        private String department;

        // Constructor
        public Builder() {}

        // Builder methods with return type Builder for method chaining
        public Builder adminId(String adminId) {
            this.adminId = adminId;
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

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        // Build method to create Admin instance
        public Admin build() {
            // Add validation if needed
            Objects.requireNonNull(adminId, "Admin ID cannot be null");
            Objects.requireNonNull(firstName, "First name cannot be null");
            Objects.requireNonNull(lastName, "Last name cannot be null");
            Objects.requireNonNull(email, "Email cannot be null");
            Objects.requireNonNull(department, "Department cannot be null");

            return new Admin(this);
        }
    }

    // equals, hashCode, and toString methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminId, admin.adminId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
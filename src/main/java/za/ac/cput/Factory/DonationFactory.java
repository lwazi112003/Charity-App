package za.ac.cput.Factory;

import za.ac.cput.Domain.Donation;

import java.time.LocalDate;

public class DonationFactory extends Donation {
    private final String adminId;
    private final AdminLevel accessLevel;

    private DonationFactory(Builder builder) {
        super(builder);
        this.adminId = builder.adminId;
        this.accessLevel = builder.accessLevel;
    }

    // Getters
    public String getAdminId() { return adminId; }
    public AdminLevel getAccessLevel() { return accessLevel; }

    public enum AdminLevel {
        SUPER_ADMIN, STANDARD_ADMIN, LIMITED_ADMIN
    }

    // Builder Pattern
    public static class Builder extends Donation.Builder {
        private String adminId;
        private AdminLevel accessLevel;

        public Builder adminId(String adminId) {
            this.adminId = adminId;
            return this;
        }

        public Builder accessLevel(AdminLevel accessLevel) {
            this.accessLevel = accessLevel;
            return this;
        }

        @Override
        public Builder userId(String userId) {
            super.userId(userId);
            return this;
        }

        @Override
        public Builder firstName(String firstName) {
            super.firstName(firstName);
            return this;
        }

        @Override
        public Builder lastName(String lastName) {
            super.lastName(lastName);
            return this;
        }

        @Override
        public Builder email(String email) {
            super.email(email);
            return this;
        }

        @Override
        public Builder phoneNumber(String phoneNumber) {
            super.phoneNumber(phoneNumber);
            return this;
        }

        @Override
        public Builder registrationDate(LocalDate registrationDate) {
            super.registrationDate(registrationDate);
            return this;
        }

        @Override
        public DonationFactory build() {
            if (adminId == null || accessLevel == null) {
                throw new IllegalStateException("Admin requires adminId and accessLevel");
            }
            super.role(UserRole.ADMIN);
            return new DonationFactory(this);
        }
    }
}
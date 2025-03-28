package za.ac.cput.domain;
/* Donation .java
Donation  model class
Author: Zimkhitha Jantjies (222809825)

*/
import za.ac.cput.util.Helper;
import java.time.LocalDate;
import java.util.Objects;

public class Donation {
    private final String donationId;
    private final double amount;
    private final LocalDate donationDate;
    private final String donorId;
    private final String eventId;

    private Donation(Builder builder) {
        this.donationId = builder.donationId;
        this.amount = builder.amount;
        this.donationDate = builder.donationDate;
        this.donorId = builder.donorId;
        this.eventId = builder.eventId;
    }

    // Getters
    public String getDonationId() { return donationId; }
    public double getAmount() { return amount; }
    public LocalDate getDonationDate() { return donationDate; }
    public String getDonorId() { return donorId; }
    public String getEventId() { return eventId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return Double.compare(donation.amount, amount) == 0 &&
                Objects.equals(donationId, donation.donationId) &&
                Objects.equals(donationDate, donation.donationDate) &&
                Objects.equals(donorId, donation.donorId) &&
                Objects.equals(eventId, donation.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(donationId, amount, donationDate, donorId, eventId);
    }

    @Override
    public String toString() {
        return "Donation{" +
                "donationId='" + donationId + '\'' +
                ", amount=" + amount +
                ", donationDate=" + donationDate +
                ", donorId='" + donorId + '\'' +
                ", eventId='" + eventId + '\'' +
                '}';
    }

    public static class Builder {
        private String donationId;
        private double amount;
        private LocalDate donationDate;
        private String donorId;
        private String eventId;

        public Builder donationId(String donationId) {
            this.donationId = donationId;
            return this;
        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder donationDate(LocalDate donationDate) {
            this.donationDate = donationDate;
            return this;
        }

        public Builder donorId(String donorId) {
            this.donorId = donorId;
            return this;
        }

        public Builder eventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder copy(Donation donation) {
            this.donationId = donation.donationId;
            this.amount = donation.amount;
            this.donationDate = donation.donationDate;
            this.donorId = donation.donorId;
            this.eventId = donation.eventId;
            return this;
        }

        public Donation build() {
            if (Helper.isNullOrEmpty(donationId)) {
                donationId = Helper.generateId();
            }
            if (amount <= 0 || Helper.isNullOrEmpty(donorId)) {
                throw new IllegalArgumentException("Invalid donation data");
            }
            if (donationDate == null) {
                donationDate = LocalDate.now();
            }
            return new Donation(this);
        }
    }
}

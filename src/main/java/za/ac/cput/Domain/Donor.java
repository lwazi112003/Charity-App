package za.ac.cput.Domain;

/**
 * Donor.java
 * Donor class using builder pattern
 * Author: Sandile Sibiya (230975623)
 * Date: 23 March 2025
 */

public class Donor {
    private String donorId;
    private String donationType;

    private Donor(Builder builder) {
        this.donorId = builder.donorId;
        this.donationType = builder.donationType;
    }

    public String getDonorId() {
        return donorId;
    }

    public String getDonationType() {
        return donationType;
    }


    @Override
    public String toString() {
        return "Donor{" +
                "donorId='" + donorId + '\'' +
                ", donationType='" + donationType + '\'' +
                '}';
    }

    //Builder class
    public static class Builder {
        private String donorId;
        private String donationType;

        public Builder donorId(String donorId) {
            this.donorId = donorId;
            return this;
        }

        public Builder donationType(String donationType) {
            this.donationType = donationType;
            return this;
        }

        public Donor build() {
            return new Donor(this);
        }
    }
}

package za.ac.cput.Domain;

/**
 * Organizer.java
 * Organizer class using builder pattern
 * Author: Sandile Sibiya (230975623)
 * Date: 23 March 2025
 */

public class Organizer {
    private String organizerId;
    private String organizerName;

    private Organizer(Builder builder) {
        this.organizerId = builder.organizerId;
        this.organizerName = builder.organizerName;
    }

    public String organizerId() {
        return organizerId;
    }

    public String organizerName() {
        return organizerName;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "organizerId='" + organizerId + '\'' +
                ", organizerName='" + organizerName + '\'' +
                '}';
    }

    //Builder class
    public static class Builder {
        private String organizerId;
        private String organizerName;

        public Builder organizerId(String organizerId) {
            this.organizerId = organizerId;
            return this;
        }

        public Builder organizerName(String organizerName) {
            this.organizerName = organizerName;
            return this;
        }

        public Organizer build() {
            return new Organizer(this);
        }
    }
}

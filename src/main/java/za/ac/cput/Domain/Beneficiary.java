package za.ac.cput.Domain;

import java.util.Objects;

public class Beneficiary {
    private String id;
    private String name;
    private String contactDetails;
    private String type; // Individual or Organization

    private Beneficiary(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.contactDetails = builder.contactDetails;
        this.type = builder.type;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getContactDetails() { return contactDetails; }
    public String getType() { return type; }

    // Builder Pattern
    public static class Builder {
        private String id;
        private String name;
        private String contactDetails;
        private String type;

        public Builder setId(String id) { this.id = id; return this; }
        public Builder setName(String name) { this.name = name; return this; }
        public Builder setContactDetails(String contactDetails) { this.contactDetails = contactDetails; return this; }
        public Builder setType(String type) { this.type = type; return this; }

        public Beneficiary build() { return new Beneficiary(this); }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beneficiary that = (Beneficiary) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Beneficiary{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

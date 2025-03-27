package za.ac.cput.factory;

import za.ac.cput.domain.Donation;
import za.ac.cput.util.Helper;
import java.time.LocalDate;

public class DonationFactory {
    public static Donation createDonation(double amount, String donorId, String eventId) {
        if (!Helper.isValidDouble(amount) || Helper.isNullOrEmpty(donorId)) {
            return null;
        }

        return new Donation.Builder()
                .amount(amount)
                .donorId(donorId)
                .eventId(eventId)
                .build();
    }

    public static Donation createDonation(String donationId, double amount, LocalDate donationDate,
                                          String donorId, String eventId) {
        if (!Helper.isValidDouble(amount) || Helper.isNullOrEmpty(donorId)) {
            return null;
        }

        return new Donation.Builder()
                .donationId(donationId)
                .amount(amount)
                .donationDate(donationDate)
                .donorId(donorId)
                .eventId(eventId)
                .build();
    }
}
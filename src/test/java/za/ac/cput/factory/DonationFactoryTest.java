package za.ac.cput.factory;


import za.ac.cput.domain.Donation;
import za.ac.cput.util.Helper;
import java.time.LocalDate;

public class DonationFactoryTest {


    public static Donation createDefaultDonation() {
        return DonationFactory.createDonation(
                Helper.generateId(),
                100.00,
                LocalDate.now(),
                "testDonor001",
                "testEvent001"
        );
    }

    public static Donation createDonationWithAmount(double amount) {
        return DonationFactory.createDonation(
                Helper.generateId(),
                amount,
                LocalDate.now(),
                "donor-" + Helper.generateId().substring(0, 5),
                "event-" + Helper.generateId().substring(0, 5)
        );
    }

    public static Donation createDonationForDonor(String donorId) {
        return DonationFactory.createDonation(
                Helper.generateId(),
                150.00,
                LocalDate.now(),
                donorId,
                "event-" + Helper.generateId().substring(0, 5)
        );
    }


    public static Donation[] createMultipleDonations(int count) {
        Donation[] donations = new Donation[count];
        for (int i = 0; i < count; i++) {
            donations[i] = createDefaultDonation();
        }
        return donations;
    }
}
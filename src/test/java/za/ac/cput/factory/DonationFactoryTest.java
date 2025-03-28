package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Donation;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class DonationFactoryTest {

    @Test
    void testCreateDonationWithRequiredFields() {
        Donation donation = DonationFactory.createDonation(100.00, "DONOR123", "EVENT456");
        assertNotNull(donation);
        assertEquals(100.00, donation.getAmount());
        assertEquals("DONOR123", donation.getDonorId());
        assertEquals("EVENT456", donation.getEventId());
        assertNotNull(donation.getDonationId());
        assertNotNull(donation.getDonationDate());
    }

    @Test
    void testCreateDonationWithNullDonorId() {
        Donation donation = DonationFactory.createDonation(100.00, null, "EVENT456");
        assertNull(donation, "Should return null when donorId is null");
    }

    @Test
    void testCreateDonationWithEmptyDonorId() {
        Donation donation = DonationFactory.createDonation(100.00, "", "EVENT456");
        assertNull(donation, "Should return null when donorId is empty");
    }

    @Test
    void testCreateDonationWithZeroAmount() {
        Donation donation = DonationFactory.createDonation(0.00, "DONOR123", "EVENT456");
        assertNull(donation, "Should return null when amount is zero");
    }

    @Test
    void testCreateDonationWithNegativeAmount() {
        Donation donation = DonationFactory.createDonation(-50.00, "DONOR123", "EVENT456");
        assertNull(donation, "Should return null when amount is negative");
    }

    @Test
    void testCreateDonationWithAllFields() {
        LocalDate testDate = LocalDate.of(2023, 5, 15);
        Donation donation = DonationFactory.createDonation(
                "DONATION-123",
                200.00,
                testDate,
                "DONOR456",
                "EVENT789"
        );

        assertNotNull(donation);
        assertEquals("DONATION-123", donation.getDonationId());
        assertEquals(200.00, donation.getAmount());
        assertEquals(testDate, donation.getDonationDate());
        assertEquals("DONOR456", donation.getDonorId());
        assertEquals("EVENT789", donation.getEventId());
    }

    @Test
    void testCreateDonationWithGeneratedId() {
        Donation donation = DonationFactory.createDonation(
                null,
                150.00,
                LocalDate.now(),
                "DONOR789",
                "EVENT012"
        );

        assertNotNull(donation);
        assertNotNull(donation.getDonationId(), "Should generate ID when null is provided");
    }

    @Test
    void testCreateDonationWithCurrentDate() {
        Donation donation = DonationFactory.createDonation(
                "DONATION-456",
                175.00,
                null,
                "DONOR321",
                "EVENT654"
        );

        assertNotNull(donation);
        assertEquals(LocalDate.now(), donation.getDonationDate(),
                "Should use current date when null is provided");
    }

    @Test
    void testGenerateId() {
        String id1 = DonationFactory.generateId();
        String id2 = DonationFactory.generateId();

        assertNotNull(id1);
        assertNotNull(id2);
        assertNotEquals(id1, id2, "Generated IDs should be unique");
    }
}
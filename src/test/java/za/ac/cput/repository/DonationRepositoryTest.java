package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Donation;
import za.ac.cput.factory.DonationFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DonationRepositoryTest {
    private static DonationRepository repository = DonationRepository.getRepository();
    private static Donation donation = DonationFactory.createDonation(150.00, "DONOR-TEST", "EVENT-TEST");

    @Test
    @Order(1)
    void testCreate() {
        Donation created = repository.create(donation);
        assertNotNull(created);
        assertEquals(donation.getDonationId(), created.getDonationId());
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    void testRead() {
        Donation read = repository.read(donation.getDonationId());
        assertNotNull(read);
        assertEquals(donation.getDonationId(), read.getDonationId());
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void testUpdate() {
        Donation updated = new Donation.Builder()
                .copy(donation)
                .amount(200.00)
                .build();
        assertNotNull(repository.update(updated));
        assertEquals(200.00, repository.read(donation.getDonationId()).getAmount());
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(4)
    void testDelete() {
        boolean success = repository.delete(donation.getDonationId());
        assertTrue(success);
        System.out.println("Deleted: " + donation.getDonationId());
    }

    @Test
    @Order(5)
    void testGetAll() {
        repository.create(donation); // Re-add for this test
        List<Donation> donations = repository.getAll();
        assertNotNull(donations);
        assertFalse(donations.isEmpty());
        System.out.println("All Donations: " + donations);
    }

    @Test
    void testFindByDonorId() {
        repository.create(DonationFactory.createDonation(100.00, "DONOR-123", "EVENT-001"));
        repository.create(DonationFactory.createDonation(200.00, "DONOR-123", "EVENT-002"));

        List<Donation> donations = repository.findByDonorId("DONOR-123");
        assertEquals(2, donations.size());
        System.out.println("Donations by Donor: " + donations);
    }

    @Test
    void testFindByEventId() {
        repository.create(DonationFactory.createDonation(300.00, "DONOR-001", "EVENT-456"));
        repository.create(DonationFactory.createDonation(400.00, "DONOR-002", "EVENT-456"));

        List<Donation> donations = repository.findByEventId("EVENT-456");
        assertEquals(2, donations.size());
        System.out.println("Donations by Event: " + donations);
    }

    @Test
    void testGetTotalDonationsForEvent() {
        repository.create(DonationFactory.createDonation(100.00, "DONOR-A", "EVENT-TOTAL"));
        repository.create(DonationFactory.createDonation(200.00, "DONOR-B", "EVENT-TOTAL"));

        double total = repository.getTotalDonationsForEvent("EVENT-TOTAL");
        assertEquals(300.00, total);
        System.out.println("Total donations for event: " + total);
    }

    @AfterAll
    static void tearDown() {
        repository.getAll().forEach(d -> repository.delete(d.getDonationId()));
    }
}























































































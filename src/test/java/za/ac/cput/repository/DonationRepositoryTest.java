package za.ac.cput.repository;

import za.ac.cput.domain.Donation;
import za.ac.cput.factory.DonationFactory;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DonationRepositoryTest implements IDonationRepository {
    private final List<Donation> donations = new ArrayList<>();
    private static DonationRepositoryTest instance;

    // Make constructor private for singleton pattern
    private DonationRepositoryTest() {
        initializeTestData();
    }

    // Singleton access method
    public static DonationRepositoryTest getRepository() {
        if (instance == null) {
            instance = new DonationRepositoryTest();
        }
        return instance;
    }

    private void initializeTestData() {
        donations.add(createTestDonation(100.00, "DONOR-001", "EVENT-001"));
        donations.add(createTestDonation(200.00, "DONOR-001", "EVENT-002"));
        donations.add(createTestDonation(300.00, "DONOR-002", "EVENT-001"));
        donations.add(createTestDonation(500.00, "DONOR-003", "EVENT-003"));
    }

    private Donation createTestDonation(double amount, String donorId, String eventId) {
        return DonationFactory.createDonation(
                Helper.generateId(),  // Fixed: Using Helper instead of DonationFactory
                amount,
                LocalDate.now(),
                donorId,
                eventId
        );
    }

    // Implement all IDonationRepository methods...
    @Override
    public Donation create(Donation donation) {
        if (donation == null || donation.getDonationId() == null) return null;
        donations.add(donation);
        return donation;
    }

    @Override
    public Donation read(String id) {
        return donations.stream()
                .filter(d -> d.getDonationId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Donation update(Donation donation) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public List<Donation> getAll() {
        return List.of();
    }

    // ... (keep all other interface method implementations) ...

    // Test-specific methods
    public void resetRepository() {
        donations.clear();
        initializeTestData();
    }

    public int count() {
        return donations.size();
    }

    @Override
    public List<Donation> findByDonorId(String donorId) {
        return List.of();
    }

    @Override
    public List<Donation> findByEventId(String eventId) {
        return List.of();
    }

    @Override
    public double getTotalDonationsForEvent(String eventId) {
        return 0;
    }
}
package za.ac.cput.repository;

import za.ac.cput.domain.Donation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DonationRepository implements IDonationRepository {
    private final List<Donation> donationList;
    private static DonationRepository repository;

    private DonationRepository() {
        this.donationList = new ArrayList<>();
    }

    public static synchronized DonationRepository getRepository() {
        if (repository == null) {
            repository = new DonationRepository();
        }
        return repository;
    }

    @Override
    public Donation create(Donation donation) {
        if (donation == null || donation.getDonationId() == null) {
            return null;
        }

        Optional<Donation> existing = donationList.stream()
                .filter(d -> d.getDonationId().equals(donation.getDonationId()))
                .findFirst();

        if (existing.isPresent()) {
            return null;
        }

        donationList.add(donation);
        return donation;
    }

    @Override
    public Donation read(String id) {
        return donationList.stream()
                .filter(d -> d.getDonationId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Donation update(Donation donation) {
        if (donation == null || donation.getDonationId() == null) {
            return null;
        }

        Donation existing = read(donation.getDonationId());
        if (existing != null) {
            donationList.remove(existing);
            donationList.add(donation);
            return donation;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Donation donation = read(id);
        if (donation != null) {
            donationList.remove(donation);
            return true;
        }
        return false;
    }

    @Override
    public List<Donation> getAll() {
        return new ArrayList<>(donationList);
    }

    @Override
    public List<Donation> findByDonorId(String donorId) {
        return donationList.stream()
                .filter(d -> d.getDonorId().equals(donorId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Donation> findByEventId(String eventId) {
        return donationList.stream()
                .filter(d -> d.getEventId().equals(eventId))
                .collect(Collectors.toList());
    }

    @Override
    public double getTotalDonationsForEvent(String eventId) {
        return donationList.stream()
                .filter(d -> d.getEventId().equals(eventId))
                .mapToDouble(Donation::getAmount)
                .sum();
    }
}
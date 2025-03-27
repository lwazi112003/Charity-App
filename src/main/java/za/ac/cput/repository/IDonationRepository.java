package za.ac.cput.repository;

import za.ac.cput.domain.Donation;
import java.util.List;

public interface IDonationRepository extends IRepository<Donation, String> {
    List<Donation> findByDonorId(String donorId);
    List<Donation> findByEventId(String eventId);
    double getTotalDonationsForEvent(String eventId);
}

package za.ac.cput.Repository;

import za.ac.cput.Domain.Donor;
import java.util.ArrayList;

/**
 * Repository class that operates CRUD Methods
 * Author: Sandile Sibiya (230975623)
 * Date: 24 March 2025
 */

public class DonorRepository implements IEDonorRepository<Donor, String> {
    private static DonorRepository repo = null;
    private ArrayList<Donor> donors;

    private DonorRepository() {
        this.donors = new ArrayList<>();
    }

    public static DonorRepository IEDonorRepository() {
        if (repo == null) {
            repo = new DonorRepository();
        }
        return repo;
    }

    @Override
    public ArrayList<Donor> getAll() {
        return this.donors;
    }

    //@Override
    public Donor create(Donor donor) {
        this.donors.add(donor);
        return donor;
    }

    @Override
    public Donor read(String donorId) {
        for (Donor donor : donors) {
            if (donor.getDonorId().equals(donorId)) {
                return donor;
            }
        }
        return null;
    }

    @Override
    public Donor update(Donor donor) {
        for (int i = 0; i < donors.size(); i++) {
            Donor existingDonor = donors.get(i);
            if (existingDonor.getDonorId().equals(donor.getDonorId())) {
                donors.set(i, donor);
                return donor;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String donorId) {  // Changed parameter from Donor to String
        for (Donor donor : donors) {
            if (donor.getDonorId().equals(donorId)) {
                donors.remove(donor);
                return true;
            }
        }
        return false;
    }
}

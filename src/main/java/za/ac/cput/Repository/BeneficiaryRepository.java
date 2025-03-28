package za.ac.cput.Repository;

import za.ac.cput.Domain.Beneficiary;

import java.util.HashSet;
import java.util.Set;

public class BeneficiaryRepository implements IRepository<Beneficiary, String> {
    private static BeneficiaryRepository repository = null;
    private Set<Beneficiary> beneficiarySet;

    private BeneficiaryRepository() {
        beneficiarySet = new HashSet<>();
    }

    public static BeneficiaryRepository getRepository() {
        if (repository == null)
            repository = new BeneficiaryRepository();
        return repository;
    }

    @Override
    public Beneficiary create(Beneficiary beneficiary) {
        beneficiarySet.add(beneficiary);
        return beneficiary;
    }

    @Override
    public Beneficiary read(String id) {
        return beneficiarySet.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Beneficiary update(Beneficiary updatedBeneficiary) {
        Beneficiary existing = read(updatedBeneficiary.getId());
        if (existing != null) {
            beneficiarySet.remove(existing);
            beneficiarySet.add(updatedBeneficiary);
            return updatedBeneficiary;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Beneficiary beneficiary = read(id);
        if (beneficiary != null) {
            beneficiarySet.remove(beneficiary);
            return true;
        }
        return false;
    }

//    @Override
//    public Set<Beneficiary> getAll() {
//        return beneficiarySet;
//    }
}

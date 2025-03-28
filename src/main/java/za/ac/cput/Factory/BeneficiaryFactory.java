package za.ac.cput.Factory;


import za.ac.cput.Domain.Beneficiary;

import java.util.UUID;

public class BeneficiaryFactory {
    public static Beneficiary createBeneficiary(String name, String contactDetails, String type) {
        String id = UUID.randomUUID().toString(); // Auto-generate unique ID
        return new Beneficiary.Builder()
                .setId(id)
                .setName(name)
                .setContactDetails(contactDetails)
                .setType(type)
                .build();
    }
}

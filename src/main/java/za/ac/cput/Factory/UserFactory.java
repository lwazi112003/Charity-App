package za.ac.cput.Factory;
//lwazi Nhlakanipho Shozi
//230220061
//27 March 2025
import za.ac.cput.Domain.User;
import za.ac.cput.Domain.Donation;
import za.ac.cput.util.Helper;

import java.util.UUID;

public class UserFactory {

    public static User createUser(String firstName, String lastName, String email, Donation.UserRole role) {
        if (!Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email address");
        }

        return new User.Builder(generateAdminId(), email)
                .setUserId(generateUserId())
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setRole(role)
                .build();
    }

    public static User createUserWithPassword(String firstName, String lastName,
                                              String email, String password, Donation.UserRole role) {
        User user = createUser(firstName, lastName, email, role);
        user.setPassword(Helper.encryptPassword(password));
        return user;
    }

    private static String generateUserId() {
        return "USER-" + UUID.randomUUID().toString().substring(0, 8);
    }

    // Specialized factory methods for different roles
    public static User createDonor(String firstName, String lastName, String email) {
        return createUser(firstName, lastName, email, UserRole.DONOR);
    }

    public static User createBeneficiary(String firstName, String lastName, String email) {
        return createUser(firstName, lastName, email, UserRole.BENEFICIARY);
    }

    public static User createAdmin(String firstName, String lastName, String email) {
        return createUser(firstName, lastName, email, UserRole.ADMIN);
    }
}

package za.ac.cput.Repository;
import  za.ac.cput.Domain.User;
import  za.ac.cput.Domain.UserRole;
import  za.ac.cput.util.AdminPrivilegeValidator;
import  za.ac.cput.util.PasswordHasher;

public final class AdminFactory {

    // Private constructor to prevent instantiation
    private AdminFactory() {}
    public static User createAdmin(String email, String firstName, String lastName) {
        return new User.Builder(generateAdminId(), email)
                .firstName(firstName)
                .lastName(lastName)
                .role(UserRole.ADMIN)
                .build();

    public static User createSecuredAdmin(String email, String plainPassword,
                                          String firstName, String lastName,
                                          int privilegeLevel) {
        AdminPrivilegeValidator.validate(privilegeLevel);

        return new User.Builder(generateAdminId(), email)
                .firstName(firstName)
                .lastName(lastName)
                .password(PasswordHasher.hash(plainPassword))
                .role(UserRole.ADMIN)
                .metadata("privilegeLevel", String.valueOf(privilegeLevel))
                .build();
    }

    public static User createSuperAdmin(String email, String securePassword) {
        return createSecuredAdmin(email, securePassword,
                "Super", "Admin",
                AdminPrivilegeValidator.MAX_PRIVILEGE_LEVEL);
    }

    private static String generateAdminId() {
        return "ADMIN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
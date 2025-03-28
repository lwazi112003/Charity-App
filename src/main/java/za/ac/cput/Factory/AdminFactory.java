package org.charity.domain.factory;

import org.charity.domain.User;
import org.charity.domain.UserRole;
import org.charity.util.AdminPrivilegeValidator;
import org.charity.util.PasswordHasher;

public final class AdminFactory {

    // Private constructor to prevent instantiation
    private AdminFactory() {}

    /**
     * Creates a basic admin user with default privileges
     */
    public static User createAdmin(String email, String firstName, String lastName) {
        return new User.Builder(generateAdminId(), email)
                .firstName(firstName)
                .lastName(lastName)
                .role(UserRole.ADMIN)
                .build();
    }

    /**
     * Creates an admin with secured password and privilege level
     */
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

    /**
     * Creates a super admin with all privileges
     */
    public static User createSuperAdmin(String email, String securePassword) {
        return createSecuredAdmin(email, securePassword,
                "Super", "Admin",
                AdminPrivilegeValidator.MAX_PRIVILEGE_LEVEL);
    }

    private static String generateAdminId() {
        return "ADMIN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
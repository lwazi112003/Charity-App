package za.ac.cput.Repository;

import org.charity.domain.Admin;
import java.util.List;

public interface DonationRepository {
    // Find admins by access level
    List<Admin> findByAccessLevel(Admin.AdminLevel accessLevel);

    // Find admin by email
    Admin findByEmail(String email);

    // Check if an admin exists by email
    boolean existsByEmail(String email);

    // Count admins by access level
    int countByAccessLevel(Admin.AdminLevel accessLevel);
}

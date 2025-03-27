package za.ac.cput.Repository;
//lwazi Nhlakanipho Shozi
//230220061
// date 25 March 2025
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

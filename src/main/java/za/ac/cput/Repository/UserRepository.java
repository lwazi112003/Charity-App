package za.ac.cput.Repository;

import za.ac.cput.Domain.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User create(User user);          // Changed from save() to create()
    Optional<User> findById(String userId);
    Optional<User> findByEmail(String email);
    List<User> findAllUsers();      // More explicit than findAll()
    boolean delete(String userId);   // Changed to return boolean for success/failure
    User update(User user);
    int getUserCount();             // More explicit than count()
}
package za.ac.cput.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.User;
import za.ac.cput.Factory.UserFactory;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    private IUserRepository repository;
    private User user1, user2;

    @BeforeEach
    void setUp() {
        repository = UserRepository.getRepository();
        user1 = UserFactory.createUser("John", "Doe", "john@example.com", "1234567890", "password123");
        user2 = UserFactory.createUser("Jane", "Smith", "jane@example.com", "0987654321", "password456");
    }

    @Test
    void testCreate() {
        User created1 = repository.create(user1);
        assertNotNull(created1);
        assertEquals(user1.getUserId(), created1.getUserId());
        System.out.println("Created: " + created1);

        User created2 = repository.create(user2);
        assertNotNull(created2);
        System.out.println("Created: " + created2);
    }

    @Test
    void testRead() {
        repository.create(user1);
        User readUser = repository.read(user1.getUserId());
        assertNotNull(readUser);
        assertEquals(user1.getUserId(), readUser.getUserId());
        System.out.println("Read: " + readUser);
    }

    @Test
    void testUpdate() {
        repository.create(user1);
        User updatedUser = new User.Builder()
                .copy(user1)
                .firstName("Johnny")
                .build();
        User result = repository.update(updatedUser);
        assertNotNull(result);
        assertEquals("Johnny", result.getFirstName());
        System.out.println("Updated: " + result);
    }

    @Test
    void testDelete() {
        repository.create(user1);
        boolean success = repository.delete(user1.getUserId());
        assertTrue(success);
        System.out.println("Deleted: " + user1.getUserId());
    }

    @Test
    void testReadAll() {
        repository.create(user1);
        repository.create(user2);
        List<User> users = repository.readAll();
        assertNotNull(users);
        assertEquals(2, users.size());
        System.out.println("All users:");
        users.forEach(System.out::println);
    }
}
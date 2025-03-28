package za.ac.cput.Repository;
//lwazi shozi
//2302200
import za.ac.cput.Domain.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepositoryImpl implements UserRepository {
    private final Map<String, User> userDatabase = new ConcurrentHashMap<>();

    @Override
    public User create(User user) {
        if (user.getUserId() == null) {
            user.setUserId(UUID.randomUUID().toString());
        }
        userDatabase.put(user.getUserId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(String userId) {
        return Optional.ofNullable(userDatabase.get(userId));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDatabase.values().stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    @Override
    public List<User> findAllUsers() {
        return new ArrayList<>(userDatabase.values());
    }

    @Override
    public boolean delete(String userId) {
        return userDatabase.remove(userId) != null;
    }

    @Override
    public User update(User user) {
        if (userDatabase.containsKey(user.getUserId())) {
            userDatabase.put(user.getUserId(), user);
            return user;
        }
        return null;
    }

    @Override
    public int getUserCount() {
        return userDatabase.size();
    }
}
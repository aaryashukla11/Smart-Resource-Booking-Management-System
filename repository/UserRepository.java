package repository;

import entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUserById(String id) {
        return users.get(id);
    }

    public Map<String, User> getAllUsers() {
        return users;
    }
}

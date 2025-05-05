package service;

import entity.*;
import repository.UserRepository;

public class UserService {
    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User login(String id, String password) {
        User user = userRepo.getUserById(id);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void registerUser(User user) {
        userRepo.addUser(user);
    }
}

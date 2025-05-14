package com.example.userapp.service;

import com.example.userapp.model.User;
import com.example.userapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class handling User entity operations.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructor-based dependency injection (recommended by Spring).
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Saves a user to the database.
     *
     * @param user - The User entity to be saved
     * @return saved User entity
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Retrieves all users from the database.
     *
     * @return List of all users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Deletes a user by ID.
     *
     * @param id - User ID
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

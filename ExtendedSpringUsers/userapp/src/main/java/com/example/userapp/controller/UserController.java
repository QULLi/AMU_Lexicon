package com.example.userapp.controller;

import com.example.userapp.model.User;
import com.example.userapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for handling User operations.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Creates a new User.
     *
     * @param user - User entity
     * @return saved User entity
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * Retrieves all users from the database.
     *
     * @return List of users
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Deletes a user by ID.
     *
     * @param id - User ID
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

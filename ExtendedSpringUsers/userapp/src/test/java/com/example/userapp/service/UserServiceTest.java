package com.example.userapp.service;

import com.example.userapp.model.User;
import com.example.userapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    
    @InjectMocks
    private UserService userService;

    @Test
    void testSaveUser_Success() {
        User user = createUser("Alice", "alice@example.com");
        User savedUser = createUser("Alice", "alice@example.com");

        when(userRepository.save(user)).thenReturn(savedUser);

        User result = userService.saveUser(user);

        assertNotNull(result);
        assertEquals("Alice", result.getName());
        assertEquals("alice@example.com", result.getEmail());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetAllUsers_MultipleUsers() {
        User user1 = createUser("Bob", "bob@example.com");
        User user2 = createUser("Carol", "carol@example.com");

        List<User> users = List.of(user1, user2);

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(2, result.size());
        assertTrue(result.contains(user1));
        assertTrue(result.contains(user2));
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testDeleteUser_ValidId() {
        Long userId = 42L;

        doNothing().when(userRepository).deleteById(userId);

        userService.deleteUser(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void testSaveUser_DuplicateEmail() {
        User user = createUser("Dave", "duplicate@example.com");

        when(userRepository.save(user)).thenThrow(new org.springframework.dao.DataIntegrityViolationException("Unique constraint violation"));

        Exception exception = assertThrows(org.springframework.dao.DataIntegrityViolationException.class, () -> {
            userService.saveUser(user);
        });

        assertTrue(exception.getMessage().contains("Unique constraint violation"));
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetAllUsers_EmptyDatabase() {
        when(userRepository.findAll()).thenReturn(List.of());

        List<User> result = userService.getAllUsers();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testDeleteUser_NonExistentId() {
        Long nonExistentId = 999L;

        doThrow(new org.springframework.dao.EmptyResultDataAccessException(1))
            .when(userRepository).deleteById(nonExistentId);

        assertThrows(org.springframework.dao.EmptyResultDataAccessException.class, 
            () -> userService.deleteUser(nonExistentId));

        verify(userRepository, times(1)).deleteById(nonExistentId);
    }
    
    /**
     * Helper method to create User objects
     */
    private User createUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        return user;
    }
}


package com.example.userapp.repository;

import com.example.userapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // This interface will automatically provide CRUD operations for User entity
    // No need to implement any methods, Spring Data JPA will handle it


}

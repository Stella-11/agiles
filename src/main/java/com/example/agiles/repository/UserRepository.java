package com.example.agiles.repository;

import com.example.agiles.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom queries here later if needed
}

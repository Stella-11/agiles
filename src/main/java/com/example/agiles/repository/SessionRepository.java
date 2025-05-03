package com.example.agiles.repository;

import com.example.agiles.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByActiveTrue();
}

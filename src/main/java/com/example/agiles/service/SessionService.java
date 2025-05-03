package com.example.agiles.service;


import com.example.agiles.model.Session;
import com.example.agiles.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public List<Session> getActiveSessions() {
        return sessionRepository.findByActiveTrue();
    }

    public Optional<Session> getSessionById(Long id) {
        return sessionRepository.findById(id);
    }

    public Session updateSession(Long id, Session updatedSession) {
        System.out.println("Updating session with ID: " + id);

        // Check if the session exists
        Session existingSession = sessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found with id: " + id));

        // Log incoming data
        System.out.println("Incoming updated session: " + updatedSession);

        // Update fields
        existingSession.setSessionName(updatedSession.getSessionName());
        existingSession.setSettings(updatedSession.getSettings()); // make sure settings is not null if required
        existingSession.setActive(updatedSession.getActive()); // or isActive(), depending on your getter

        // Save and return
        Session savedSession = sessionRepository.save(existingSession);
        System.out.println("Session updated successfully: " + savedSession);

        return savedSession;
    }



    public boolean deleteSession(Long id) {
        if (sessionRepository.existsById(id)) {
            sessionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


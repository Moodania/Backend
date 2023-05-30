package com.mood.Moodania.application.services.implementations;

import com.mood.Moodania.application.dto.UserDto;
import com.mood.Moodania.dataAccess.data.repositories.WebSocketSessionRepository;
import com.mood.Moodania.dataAccess.exceptions.UserWithSocketAlreadyExists;
import com.mood.Moodania.dataAccess.exceptions.UserWithSocketNotFoundException;
import com.mood.Moodania.dataAccess.models.UserWithSocket;
import com.mood.Moodania.presentation.models.SearchOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.UUID;

@Service
public class WebSocketSessionService {

    WebSocketSessionRepository sessionRepository;

    public WebSocketSessionService(@Autowired WebSocketSessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public boolean isPresent(String id) {
        return sessionRepository.isPresent(id);
    }

    public void updateConnection(UUID userID, WebSocketSession session) {
        try {
            sessionRepository.updateUserSession(new UserWithSocket(session,userID));
        } catch (UserWithSocketNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addNewConnection(UUID userId, WebSocketSession session)  {
        try {
            sessionRepository.addUserSession(new UserWithSocket(session,userId));
        } catch (UserWithSocketAlreadyExists e) {
            throw new RuntimeException(e);
        }
    }

    public void addToSearchQueue(UUID userId, SearchOptions searchingParams) {
        try {
            sessionRepository.addUserToSearchQueue(userId, searchingParams.interests(), searchingParams.region(), searchingParams.age());
        } catch (UserWithSocketNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

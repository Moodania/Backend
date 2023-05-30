package com.mood.Moodania.application.services;

import com.mood.Moodania.presentation.models.SearchOptions;
import org.springframework.web.socket.WebSocketSession;

import java.util.UUID;

public interface WebSocketSessionServiceInterface {



    public boolean isPresent(String id);

    public void updateConnection(UUID userID, WebSocketSession session);

    public void addNewConnection(UUID userId, WebSocketSession session);

    public void addToSearchQueue(UUID userId, SearchOptions searchingParams);

    }

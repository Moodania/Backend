package com.mood.Moodania.dataAccess.models;

import org.springframework.web.socket.WebSocketSession;

import java.util.UUID;

public record UserInQueue(WebSocketSession session, UUID userId, String sessionId, String region, int age, String[] interests) {
}

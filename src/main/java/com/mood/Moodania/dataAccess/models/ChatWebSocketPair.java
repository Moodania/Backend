package com.mood.Moodania.dataAccess.models;

import org.springframework.web.socket.WebSocketSession;

import java.util.UUID;

public class ChatWebSocketPair {
    private WebSocketSession firstPersonSession;
    private WebSocketSession secondPersonSession;
    private UUID firstUserId;
    private UUID secondUserId;



}

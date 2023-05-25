package com.mood.Moodania.presentation.websockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.UUID;

@Component
public class MyWebsocketHandler extends TextWebSocketHandler {
    Logger log = LoggerFactory.getLogger(MyWebsocketHandler.class);

    public HashMap<String, WebSocketSession> mapa = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        mapa.put(session.getId(), session);
        log.info("New session detected: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        for (WebSocketSession ses : mapa.values()) {
            ses.sendMessage(message);
            log.info(ses.getId() + " sended " + message.getPayload());
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        mapa.remove(session.getId());
        log.info("connection finished: " + session.getId());
    }
}
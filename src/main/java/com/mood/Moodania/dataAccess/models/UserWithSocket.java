package com.mood.Moodania.dataAccess.models;

import org.springframework.web.socket.WebSocketSession;

import java.util.UUID;


public class UserWithSocket {
    private WebSocketSession session;
    private String sessionId;
    private UUID userId;

    public UserWithSocket(WebSocketSession session, UUID userId) {
        this.session = session;
        this.sessionId = session.getId();
        this.userId = userId;
    }

    public WebSocketSession getSession() {
        return session;
    }

    public void setSession(WebSocketSession session) {
        this.session = session;
    }

    public String getSessionId() {
        return sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserWithSocket that = (UserWithSocket) o;

        if (!session.equals(that.session)) return false;
        if (!sessionId.equals(that.sessionId)) return false;
        return userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        int result = session.hashCode();
        result = 31 * result + sessionId.hashCode();
        result = 31 * result + userId.hashCode();
        return result;
    }

    public UUID getUserId() {
        return userId;
    }
}

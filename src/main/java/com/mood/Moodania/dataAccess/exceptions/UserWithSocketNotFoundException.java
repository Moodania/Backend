package com.mood.Moodania.dataAccess.exceptions;

import java.util.UUID;

public class UserWithSocketNotFoundException extends Throwable {
    public UserWithSocketNotFoundException() {
    }
    public UserWithSocketNotFoundException(UUID userId, String newSocketSession){
        super("user with id: " + userId + " and new socket session: " + newSocketSession + " was not found");
    }

}

package com.mood.Moodania.application.exceptions.alreadyExistExceptions;

public class EmailAlreadyExistException extends Exception {
    public EmailAlreadyExistException(String email) {
        super("Email " + email + " already exist");
    }
}

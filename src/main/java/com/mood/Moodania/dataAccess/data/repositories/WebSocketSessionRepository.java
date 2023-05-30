package com.mood.Moodania.dataAccess.data.repositories;

import com.mood.Moodania.dataAccess.exceptions.UserWithSocketAlreadyExists;
import com.mood.Moodania.dataAccess.exceptions.UserWithSocketNotFoundException;
import com.mood.Moodania.dataAccess.models.UserInQueue;
import com.mood.Moodania.dataAccess.models.UserWithSocket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

@Repository
public class WebSocketSessionRepository {
    ArrayList<UserWithSocket> allUsers = new ArrayList<>(1000);
    ArrayList<UserInQueue> usersInSearchQueue = new ArrayList<>(1000);


    public void updateUserSession(UserWithSocket updatedUser) throws UserWithSocketNotFoundException {
        if (updatedUser == null)
            throw new NullPointerException("newSession is null");
        var userWithSocket = allUsers.stream()
                .filter(x -> x.getUserId() == updatedUser.getUserId())
                .findAny()
                .orElse(null);
        if (userWithSocket == null)
            throw new UserWithSocketNotFoundException(updatedUser.getUserId(), updatedUser.getSessionId());
        else
            allUsers.add(allUsers.indexOf(userWithSocket), updatedUser);
    }

    public void addUserSession(UserWithSocket newUser) throws UserWithSocketAlreadyExists {
        if (newUser == null)
            throw new NullPointerException("newUser is null");
        if (allUsers.contains(newUser))
            throw new UserWithSocketAlreadyExists();
        allUsers.add(newUser);
    }

    public void addUserToSearchQueue(UUID userId, String[] interests, String region, int age) throws UserWithSocketNotFoundException {
        var userWithSocket = allUsers.stream()
                .filter(x -> x.getUserId() == userId)
                .findAny()
                .orElse(null);
        if (userWithSocket == null)
            throw new UserWithSocketNotFoundException();
        usersInSearchQueue.add(new UserInQueue(userWithSocket.getSession(), userId, userWithSocket.getSessionId(), region, age, interests));
    }

    public boolean isPresent(String sessionId) {
        return allUsers.stream().anyMatch(x -> Objects.equals(x.getSessionId(), sessionId));
    }
}

package com.mood.Moodania.application.services.implementations;

import com.mood.Moodania.application.dto.UserDto;
import com.mood.Moodania.application.services.SearchServiceInterface;
import com.mood.Moodania.dataAccess.data.repositories.WebSocketSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SearchService implements SearchServiceInterface {

    WebSocketSessionRepository sessionRepository;

    public SearchService(@Autowired WebSocketSessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public UserDto searchByParams(String region, int age, String[] interests) {
        return null;
    }
}

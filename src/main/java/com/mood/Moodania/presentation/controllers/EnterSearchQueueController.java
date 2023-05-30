package com.mood.Moodania.presentation.controllers;

import com.mood.Moodania.application.services.implementations.WebSocketSessionService;
import com.mood.Moodania.presentation.models.SearchOptions;
import com.mood.Moodania.application.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Controller
public class EnterSearchQueueController {
    WebSocketSessionService socketSessionService;

    public EnterSearchQueueController(@Autowired WebSocketSessionService socketSessionService) {
        this.socketSessionService = socketSessionService;
    }

    @PostMapping("mood/enter")
    public void enterQueue(@RequestBody SearchOptions searchingParams) {
        //TODO(HttpContextHolder)
        var userId = UUID.randomUUID();
        socketSessionService.addToSearchQueue(userId, searchingParams);
    }
}

package com.mood.Moodania.presentation.controllers;

import com.mood.Moodania.presentation.models.SearchOptions;
import com.mood.Moodania.application.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchCompanionController {


    @GetMapping("mood/search")
    public UserDto getCompanion(@RequestBody SearchOptions searchingParams) {
        var
    }
}

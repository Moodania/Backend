package com.mood.Moodania.application.dto;

import java.util.UUID;

public record UserDto(UUID accountId, UUID userId, String username, String email, String age, String[] interests) {
}

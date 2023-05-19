package com.mood.Moodania.application.dto;

import java.util.UUID;

public record AccountDto(UUID accountId, UUID userId, String username, String email, String Role) {

}

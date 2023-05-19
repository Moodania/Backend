package com.mood.Moodania.application.services;

import com.mood.Moodania.application.dto.RoleDto;
import com.mood.Moodania.dataAccess.models.ERole;
import org.hibernate.exception.ConstraintViolationException;

public interface RoleServiceInterface {

    RoleDto createNewRole(ERole role) throws ConstraintViolationException;
}

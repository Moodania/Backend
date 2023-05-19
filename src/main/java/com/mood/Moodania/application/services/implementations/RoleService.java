package com.mood.Moodania.application.services.implementations;

import com.mood.Moodania.application.dto.RoleDto;
import com.mood.Moodania.application.services.RoleServiceInterface;
import com.mood.Moodania.dataAccess.models.ERole;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements RoleServiceInterface {

    @Override
    public RoleDto createNewRole(ERole role) throws ConstraintViolationException {
        return null;
    }
}

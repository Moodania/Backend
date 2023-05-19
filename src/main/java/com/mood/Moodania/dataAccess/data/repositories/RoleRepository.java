package com.mood.Moodania.dataAccess.data.repositories;


import com.mood.Moodania.dataAccess.entities.RoleEntity;
import com.mood.Moodania.dataAccess.models.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
    RoleEntity findByName(ERole role);
    boolean existsByName(ERole role);
}

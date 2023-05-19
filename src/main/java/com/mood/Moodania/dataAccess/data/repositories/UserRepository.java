package com.mood.Moodania.dataAccess.data.repositories;

import com.mood.Moodania.dataAccess.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

}

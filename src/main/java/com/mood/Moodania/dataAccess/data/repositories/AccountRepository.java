package com.mood.Moodania.dataAccess.data.repositories;

import com.mood.Moodania.dataAccess.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {
    Optional<AccountEntity> findAccountEntityByEmail(String email);
}

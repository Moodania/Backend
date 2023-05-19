package com.mood.Moodania.dataAccess.data.repositories;

import com.mood.Moodania.dataAccess.entities.StatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StatisticsRepository extends JpaRepository<StatisticsEntity, UUID> {

}

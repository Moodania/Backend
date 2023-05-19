package com.mood.Moodania.dataAccess.entities;

import com.mood.Moodania.dataAccess.models.ERole;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "roles",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
    })
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private ERole name;

    public RoleEntity(ERole name) {
        this.name = name;
    }
    public RoleEntity() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ERole getEName() {
        return name;
    }

    public void setEName(ERole name) {
        this.name = name;
    }
}

package com.mood.Moodania.dataAccess.data.initialization;

import com.mood.Moodania.dataAccess.data.repositories.RoleRepository;
import com.mood.Moodania.dataAccess.entities.RoleEntity;
import com.mood.Moodania.dataAccess.models.ERole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        for (ERole eRole : ERole.values()) {
            if (!roleExists(eRole)) {
                RoleEntity role = new RoleEntity(eRole);
                roleRepository.save(role);
            }
        }
    }

    private boolean roleExists(ERole eRole) {
        return roleRepository.existsByName(eRole);
    }
}

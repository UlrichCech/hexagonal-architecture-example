package de.ulrichcech.hae.infrastructure.adapter.persistence.user.services;

import de.ulrichcech.hae.application.domain.user.model.User;
import de.ulrichcech.hae.application.ports.user.out.UserRoleRepository;
import jakarta.ejb.DependsOn;
import jakarta.ejb.Stateless;

@Stateless
@DependsOn("FlywayMigrator")
public class JpaUserRoleRepository implements UserRoleRepository {

    @Override
    public void assignRoleToUser(String role, User user) {

    }
}

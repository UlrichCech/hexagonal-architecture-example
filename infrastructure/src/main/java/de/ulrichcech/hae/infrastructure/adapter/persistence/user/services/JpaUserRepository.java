package de.ulrichcech.hae.infrastructure.adapter.persistence.user.services;

import de.ulrichcech.hae.application.domain.user.model.User;
import de.ulrichcech.hae.application.domain.user.model.UserToRegister;
import de.ulrichcech.hae.application.ports.user.out.UserRepository;
import de.ulrichcech.hae.infrastructure.adapter.persistence.user.entity.UserEntity;
import jakarta.ejb.DependsOn;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
@DependsOn("FlywayMigrator")
public class JpaUserRepository implements UserRepository {

    @PersistenceContext(unitName = "pu_hexagon")
    EntityManager entityManager;

    @Override
    public User save(UserToRegister newUserToRegister) {
        UserEntity entity = new UserEntity(newUserToRegister);
        entityManager.persist(entity);
        return new User(entity.getId(), entity.getFirstname(), entity.getLastname(), entity.getEmail());
    }
}

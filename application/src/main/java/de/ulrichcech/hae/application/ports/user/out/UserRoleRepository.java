package de.ulrichcech.hae.application.ports.user.out;

import de.ulrichcech.hae.application.domain.user.model.User;

public interface UserRoleRepository {

    void assignRoleToUser(String role, User user);

}

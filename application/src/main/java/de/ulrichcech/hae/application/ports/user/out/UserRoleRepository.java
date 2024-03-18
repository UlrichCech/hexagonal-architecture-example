package de.ulrichcech.hae.application.ports.user.out;

import de.ulrichcech.hae.application.ports.user.WrappedUser;

public interface UserRoleRepository {

    void assignRoleToUser(String role, WrappedUser user);

}

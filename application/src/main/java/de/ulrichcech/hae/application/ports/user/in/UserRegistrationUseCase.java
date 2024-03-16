package de.ulrichcech.hae.application.ports.user.in;

import de.ulrichcech.hae.application.domain.user.model.User;
import de.ulrichcech.hae.application.domain.user.model.UserToRegister;

public interface UserRegistrationUseCase {

    boolean validateNewUser(UserToRegister newUserToRegister);

    User createUser(UserToRegister newUserToRegister);

    void assignDefaultRolesToUser(User user);

}

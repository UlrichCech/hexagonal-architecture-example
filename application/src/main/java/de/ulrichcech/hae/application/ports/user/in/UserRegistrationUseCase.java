package de.ulrichcech.hae.application.ports.user.in;

import de.ulrichcech.hae.application.ports.user.WrappedUser;
import de.ulrichcech.hae.application.ports.user.WrappedUserToRegister;

public interface UserRegistrationUseCase {

    boolean validateNewUser(WrappedUserToRegister newUserToRegister);

    WrappedUser createUser(WrappedUserToRegister newUserToRegister);

    void assignDefaultRolesToUser(WrappedUser user);

}

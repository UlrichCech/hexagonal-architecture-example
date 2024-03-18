package de.ulrichcech.hae.application.ports.user.out;

import de.ulrichcech.hae.application.ports.user.WrappedUser;
import de.ulrichcech.hae.application.ports.user.WrappedUserToRegister;

public interface UserRepository {

    WrappedUser registerNewUser(WrappedUserToRegister newUserToRegister);

}

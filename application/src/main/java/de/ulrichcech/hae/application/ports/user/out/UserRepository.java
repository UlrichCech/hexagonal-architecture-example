package de.ulrichcech.hae.application.ports.user.out;

import de.ulrichcech.hae.application.domain.user.model.User;
import de.ulrichcech.hae.application.domain.user.model.UserToRegister;

public interface UserRepository {

    User save(UserToRegister newUserToRegister);

}

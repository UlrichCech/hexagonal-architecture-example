package de.ulrichcech.hae.application.domain.user.services;

import de.ulrichcech.hae.application.ports.TransactionalPort;
import de.ulrichcech.hae.application.ports.user.WrappedUser;
import de.ulrichcech.hae.application.ports.user.WrappedUserToRegister;
import de.ulrichcech.hae.application.ports.user.in.UserRegistrationUseCase;
import de.ulrichcech.hae.application.ports.user.out.UserRepository;
import de.ulrichcech.hae.application.ports.user.out.UserRoleRepository;

public class UserRegistrationService implements UserRegistrationUseCase {

    private final TransactionalPort transactionalPort;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;


    public UserRegistrationService(TransactionalPort transactionalPort, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.transactionalPort = transactionalPort;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }


    public void registerUser(WrappedUserToRegister newUserToRegister) {
        transactionalPort.executeInTransaction(() -> {
            if (! validateNewUser(newUserToRegister)) {
                throw new IllegalArgumentException("Please use other user data.");
            }
            var user = createUser(newUserToRegister);
            assignDefaultRolesToUser(user);
            return null;
        });
    }


    @Override
    public boolean validateNewUser(WrappedUserToRegister newUserToRegister) {
        return true;
    }

    @Override
    public WrappedUser createUser(WrappedUserToRegister newUserToRegister) {
        return userRepository.registerNewUser(newUserToRegister);
    }

    @Override
    public void assignDefaultRolesToUser(WrappedUser user) {
        userRoleRepository.assignRoleToUser("UserRole", user);
    }
}

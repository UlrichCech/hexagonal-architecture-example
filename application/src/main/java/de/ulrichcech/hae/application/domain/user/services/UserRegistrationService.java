package de.ulrichcech.hae.application.domain.user.services;

import de.ulrichcech.hae.application.domain.user.model.User;
import de.ulrichcech.hae.application.domain.user.model.UserToRegister;
import de.ulrichcech.hae.application.ports.TransactionalPort;
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


    public void registerUser(UserToRegister newUserToRegister) {
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
    public boolean validateNewUser(UserToRegister newUserToRegister) {
        return true;
    }

    @Override
    public User createUser(UserToRegister newUserToRegister) {
        return userRepository.save(newUserToRegister);
    }

    @Override
    public void assignDefaultRolesToUser(User user) {
        userRoleRepository.assignRoleToUser("UserRole", user);
    }
}

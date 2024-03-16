package de.ulrichcech.hae.application.domain.user.model;

import java.util.Objects;

public record UserToRegister(String eMail, String firstName, String lastName) {

    public UserToRegister(String eMail, String firstName, String lastName) {
        this.eMail = Objects.requireNonNull(eMail);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
    }

}

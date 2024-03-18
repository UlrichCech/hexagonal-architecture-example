package de.ulrichcech.hae.infrastructure.adapter.persistence.user.entity;

import de.ulrichcech.hae.application.ports.user.WrappedUserToRegister;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table(name = "USERS_1")
@Entity
public class UserEntity {

    @Id
    @Column(name = "_ID")
    private String id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "EMAIL")
    private String email;


    public UserEntity() {
        // JPA
    }

    public UserEntity(WrappedUserToRegister newUserToRegister) {
        this.id = UUID.randomUUID().toString();
        this.email = newUserToRegister.email();
        this.firstname = newUserToRegister.firstname();
        this.lastname = newUserToRegister.lastname();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

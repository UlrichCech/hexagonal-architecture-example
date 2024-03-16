package de.ulrichcech.hae.web.user;

import de.ulrichcech.hae.application.domain.user.model.UserToRegister;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserRegistrationRequest {

    private String email;

    private String firstname;

    private String lastname;


    public UserRegistrationRequest() {
        // JSON
    }

    public UserToRegister userToRegister() {
        return new UserToRegister(this.getEmail(), this.getFirstname(), this.getLastname());
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}

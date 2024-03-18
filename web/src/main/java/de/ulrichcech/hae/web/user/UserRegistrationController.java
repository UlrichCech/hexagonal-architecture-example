package de.ulrichcech.hae.web.user;

import de.ulrichcech.hae.application.domain.user.services.UserRegistrationService;
import de.ulrichcech.hae.application.ports.user.out.UserRepository;
import de.ulrichcech.hae.application.ports.user.out.UserRoleRepository;
import de.ulrichcech.hae.infrastructure.adapter.persistence.JpaTransactionAdapter;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.security.PermitAll;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/")
@RequestScoped
@Consumes(UserRegistrationController.MEDIA_TYPE_JSON_STRING)
@Produces(UserRegistrationController.MEDIA_TYPE_JSON_STRING)
public class UserRegistrationController {

    public static final String MEDIA_TYPE_JSON_STRING = "application/json;charset=UTF-8"; // have to be public

    private static final MediaType MEDIA_TYPE_JSON = new MediaType("application", "json", "UTF-8");

    @EJB
    JpaTransactionAdapter transactionalPort;

    @EJB
    UserRepository userRepository;
    @EJB
    UserRoleRepository userRoleRepository;


    private UserRegistrationService userRegistrationService;

    @PostConstruct
    public void init() {
        userRegistrationService = new UserRegistrationService(transactionalPort, userRepository, userRoleRepository);
    }


    @POST
    @Path("users/register")
    @PermitAll
    public Response registerUser(UserRegistrationRequest registrationRequest) {
        userRegistrationService.registerUser(registrationRequest.userToRegister());
        return Response.ok().build();
    }

    @GET
    @Path("users")
    @PermitAll
    public Response getUser() {
        return Response.ok().build();
    }

}

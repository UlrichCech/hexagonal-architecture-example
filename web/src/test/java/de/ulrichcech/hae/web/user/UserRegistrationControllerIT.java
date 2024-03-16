package de.ulrichcech.hae.web.user;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.json.Json;
import javax.json.JsonObject;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Disabled
class UserRegistrationControllerIT {
    public static final String BASE_URI = "http://localhost:8080/api";

    private static Client client;


    @BeforeAll
    public static void init() {
        client = ClientBuilder.newClient();
    }

    @Test
    void getUser() throws ExecutionException, InterruptedException {
        Future<Response> result = client.target(BASE_URI + "/users")
                .request()
                .header("Accept", MediaType.APPLICATION_JSON)
                .header("Accept-Language", "de-DE")
                .buildGet()
                .submit();
        final Response response = result.get();
        assertThat(response.getStatus(), is(200));
    }

    @Test
    void registerUser() throws ExecutionException, InterruptedException {
        var uri = BASE_URI + "/users/register";
        JsonObject request = Json.createObjectBuilder()
                .add("firstname", "Bruce")
                .add("lastname", "Wayne")
                .add("email", "batman@gotham.org")
                .build();
        final Invocation.Builder builder = client.target(uri)
                .request()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Accept-Language", "de-DE")
                .header("x-request-id", UUID.randomUUID().toString());
        Future<Response> result = builder
                .buildPost(Entity.entity(request.toString(), "application/json"))
                .submit();
        final Response response = result.get();
        assertThat(response.getStatus(), is(200));
    }
}
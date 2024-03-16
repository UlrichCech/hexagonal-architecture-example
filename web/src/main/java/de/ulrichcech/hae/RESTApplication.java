package de.ulrichcech.hae;

import jakarta.annotation.security.DeclareRoles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.auth.LoginConfig;

/**
 * The JAX-RS configuration.
 *
 * @author Ulrich Cech
 */
@LoginConfig(authMethod = "MP-JWT", realmName = "MP-JWT")
@DeclareRoles({"ROLE_USER_IN_REGISTRATION","ROLE_USER_IN_APPROVAL","ROLE_ALL_USERS","ROLE_BC_TEAM","ROLE_ADMIN","ROLE_TAG_MODERATOR","ROLE_PROJECT_MODERATOR","ROLE_PROJECT_CREATOR","ROLE_FORUM_MODERATOR","ROLE_VIDEO_CHAT_MODERATOR", "ROLE_BLOG_ADMIN"})
@ApplicationScoped
@ApplicationPath("/api")
public class RESTApplication extends Application {

}

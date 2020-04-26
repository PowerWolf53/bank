package by.bsuir.vtb.service.authentication;

import by.bsuir.vtb.service.authentication.model.Credentials;
import by.bsuir.vtb.service.authentication.model.SignUpCredentials;

public interface AuthenticationService {

    String signIn(Credentials credentials);

    String signUp(SignUpCredentials credentials);
}

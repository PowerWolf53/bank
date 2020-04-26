package by.bsuir.vtb.controller;

import by.bsuir.vtb.service.authentication.model.AuthenticationToken;
import by.bsuir.vtb.service.authentication.model.Credentials;
import by.bsuir.vtb.service.authentication.AuthenticationService;
import by.bsuir.vtb.service.authentication.model.SignUpCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/vtb/auth", produces = APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(value = "/sign_in")
    public @ResponseBody AuthenticationToken signIn(@RequestBody Credentials credentials){
        String token = authenticationService.signIn(credentials);
        return AuthenticationToken.builder().token(token).build();
    }

    @PostMapping(value = "/sign_up")
    public @ResponseBody AuthenticationToken signUp(@RequestBody SignUpCredentials credentials){
        String token = authenticationService.signUp(credentials);
        return AuthenticationToken.builder().token(token).build();
    }
}

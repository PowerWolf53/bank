package by.bsuir.vtb.service.authentication;

import by.bsuir.vtb.service.authentication.model.Credentials;
import by.bsuir.vtb.repository.model.User;
import by.bsuir.vtb.repository.user.UserRepository;
import by.bsuir.vtb.service.authentication.exception.UnauthorizedException;
import by.bsuir.vtb.service.authentication.exception.UserAlreadyExistsException;
import by.bsuir.vtb.service.authentication.model.SignUpCredentials;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    public static final String SECRET_KEY = "vtb_secret";

    @Autowired
    UserRepository userRepository;

    @Override
    public String signIn(Credentials credentials) {
        Optional<User> user = userRepository.findByLogin(credentials.getLogin());
        if (user.isPresent()) {
            return generateToken(user.get());
        } else {
            throw new UnauthorizedException();
        }
    }

    @Override
    public String signUp(SignUpCredentials credentials) {
        Optional<User> user = userRepository.findByLogin(credentials.getLogin());
        if (!user.isPresent()) {
            User newUser = User.builder()
                    .login(credentials.getLogin())
                    .password(credentials.getPassword())
                    .name(credentials.getName())
                    .surname(credentials.getSurname())
                    .count(0d)
                    .build();
            User saved = userRepository.save(newUser);
            return generateToken(saved);
        } else {
            throw new UserAlreadyExistsException();
        }
    }

    private String generateToken(User user) {
        return  JWT.create()
                .withIssuer("auth0")
                .withSubject(user.getLogin())
                .withClaim("id", user.getId())
                .sign(Algorithm.HMAC256(SECRET_KEY.getBytes()));
    }
}

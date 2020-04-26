package by.bsuir.vtb.service.authentication.exception;

public class UnauthorizedException extends AuthenticationException {

    public UnauthorizedException(){
        super("Wrong login or password");
    }
}

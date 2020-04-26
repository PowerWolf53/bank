package by.bsuir.vtb.service.authentication.exception;

public class UserAlreadyExistsException extends AuthenticationException  {

    public UserAlreadyExistsException(){
        super("User already exists");
    }
}

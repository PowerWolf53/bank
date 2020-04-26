package by.bsuir.vtb.controller.exception;

import by.bsuir.vtb.controller.model.ErrorDetail;
import by.bsuir.vtb.service.authentication.exception.AuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    public static final int UNAUTHORIZED_STATUS = 401;

    @ExceptionHandler(AuthenticationException.class)
    protected ResponseEntity<ErrorDetail> handleAuthenticationException(AuthenticationException exception){
        return ResponseEntity.status(UNAUTHORIZED_STATUS).body(ErrorDetail.builder().error(exception.getMessage()).build());
    }
}

package by.bsuir.vtb.service.authentication.model;

import lombok.Data;

@Data
public class SignUpCredentials extends Credentials {

    private String confirmPassword;

    private String name;

    private String surname;
}

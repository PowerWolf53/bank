package by.bsuir.vtb.controller;

import by.bsuir.vtb.service.authentication.model.AuthenticationToken;
import by.bsuir.vtb.service.authentication.model.Credentials;
import by.bsuir.vtb.service.user.UserService;
import by.bsuir.vtb.service.user.model.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/vtb/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/info")
    public @ResponseBody UserInfoDto getInfo(){
        return  userService.getInfo();
    }
}

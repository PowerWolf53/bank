package by.bsuir.vtb.service;

import by.bsuir.vtb.repository.model.User;
import by.bsuir.vtb.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class Authenticated {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getUser(){
        Long id = Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getCredentials().toString());
        return userRepository.findById(id);
    }
}

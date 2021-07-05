package com.example.moodtracker.controller.user;

import com.example.moodtracker.controller.repository.UserRepository;
import com.example.moodtracker.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserOperations{
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserRepository userRepository;


 /*   public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    @Override
    public void register(User newUser) {
    }
}

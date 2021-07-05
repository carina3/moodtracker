package com.example.moodtracker.controller.user;

import com.example.moodtracker.model.user.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
public interface UserOperations {

    @PostMapping("/signup")
    public void register(@RequestBody User newUser);
}

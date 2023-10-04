package com.hs.userservice.controller;

import com.hs.userservice.model.User;
import com.hs.userservice.service.UserCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
public class UserCommandController {

    @Autowired
    UserCommandService userCommandService;

    @PostMapping("/signup")
    @ResponseStatus(CREATED)
    public void createNewUser(@RequestBody final User user) {
        log.info("Received request to create new user");
        userCommandService.createNewUser(user);
    }
}

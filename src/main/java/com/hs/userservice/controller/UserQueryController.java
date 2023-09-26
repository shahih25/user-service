package com.hs.userservice.controller;

import com.hs.userservice.model.User;
import com.hs.userservice.service.UserQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserQueryController {

    @Autowired
    UserQueryService userQueryService;

    @GetMapping("/get-user")
    public User getUser(@RequestParam final String username) {
        log.info("Getting user: {}", username);
        return userQueryService.getUserByUsername(username);
    }
}

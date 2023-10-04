package com.hs.userservice.service;

import com.hs.userservice.model.User;
import com.hs.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserCommandService {

    @Autowired
    UserRepository userRepository;

    public void createNewUser(final User user) {
        log.info("Received request to create a new user: {}", user.getUsername());
        userRepository.save(user);
        log.info("Saved in db");
    }
}

package com.hs.userservice.service;

import com.hs.userservice.model.User;
import com.hs.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserQueryService {

    @Autowired
    UserRepository userRepository;

    public User getUserByUsername(final String username) {
        return userRepository.findById(username).orElseThrow();
    }
}

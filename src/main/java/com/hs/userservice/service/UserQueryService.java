package com.hs.userservice.service;

import com.hs.userservice.model.User;
import com.hs.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserQueryService {

    @Autowired
    UserRepository userRepository;

    public User getUserByUsername(final String username) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("firstName").ascending());
        Page<User> users = userRepository.findAll(pageable);
        List<User> usersAll = userRepository.findAll();
        return userRepository.findById(username).orElseThrow();
    }

    public User getAllUsers(final String username) {
        Pageable pageable = PageRequest.of(1, 10, Sort.Direction.ASC);
        Page<User> users = userRepository.findAll(pageable);
        return userRepository.findById(username).orElseThrow();
    }
}

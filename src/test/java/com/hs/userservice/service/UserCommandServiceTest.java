package com.hs.userservice.service;

import com.hs.userservice.model.User;
import com.hs.userservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserCommandServiceTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    UserCommandService userCommandService;

    @Test
    void testUserSignup() {
        final User user = new User("user", "password", "first", "last", LocalDate.now(), 0L);
        when(userRepository.save(any(User.class))).thenReturn(user);
        assertThatNoException().isThrownBy(() -> userCommandService.createNewUser(user));
    }
}

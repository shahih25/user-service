package com.hs.userservice.service;

import com.hs.userservice.model.User;
import com.hs.userservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserQueryServiceTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    UserQueryService userQueryService;

    @Test
    void testGetUser() {
        final User user = new User("user", "password", "first", "last", LocalDate.now(), 0L);
        when(userRepository.findById(anyString())).thenReturn(Optional.of(user));
        assertThat(userQueryService.getUserByUsername(user.getUsername())).isNotNull()
                .isEqualTo(user);
    }

    @Test
    void testUserNotFound() {
        when(userRepository.findById(anyString())).thenReturn(Optional.empty());
        assertThatException().isThrownBy(() -> userQueryService.getUserByUsername("abcd"));
    }
}

package com.hs.userservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hs.userservice.model.User;
import com.hs.userservice.service.UserCommandService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserCommandControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    UserCommandService userCommandService;

    @Autowired
    ObjectMapper mapper;

    @SneakyThrows
    @Test
    void testUserSignUp() {
        doNothing().when(userCommandService).createNewUser(any(User.class));
        final User user = new User("username", "password", "first", "last", LocalDate.now(), 0L);
        mvc.perform(post("/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(user)))
                .andExpect(status().isCreated());
    }
}

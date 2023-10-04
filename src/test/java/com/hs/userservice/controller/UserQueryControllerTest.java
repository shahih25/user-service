package com.hs.userservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hs.userservice.model.User;
import com.hs.userservice.service.UserQueryService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserQueryControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserQueryService userQueryService;

    @Autowired
    ObjectMapper mapper;

    @SneakyThrows
    @Test
    void testGetUser() {
        when(userQueryService.getUserByUsername(anyString()))
                .thenReturn(new User("username", "password", "first", "last", LocalDate.now(), 0L));
        mvc.perform(get("/get-user?username=username"))
                .andExpect(status().isOk());
    }
}

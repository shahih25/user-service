package com.hs.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("users")
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private String username;

    private String password;

    @NonNull
    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;
}

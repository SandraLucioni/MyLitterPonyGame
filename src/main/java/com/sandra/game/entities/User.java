package com.sandra.game.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Document(collection = "user")
@Getter
@Setter
public class User {
    @Id
    @NotNull
    private String id;

    private String password;
    private String name;
    private String photoProfile;
    @Email
    private String email;

    private UserPlayer userPlayer;
}

package com.sandra.game.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    private List<GameStatus> gameStatuses;

    public User(String password, String name, String photoProfile, String email) {
        this.password = password;
        this.name = name;
        this.photoProfile = photoProfile;
        this.email = email;
    }
}

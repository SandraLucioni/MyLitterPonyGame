package com.sandra.game.dto;

import com.sandra.game.entities.UserPlayer;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "user_dto")
@Getter
@Setter
public class UserDTO {
    private String name;
    private UserPlayer userPlayer;

    public UserDTO(String name, UserPlayer userPlayer) {
        this.name = name;
        this.userPlayer = userPlayer;
    }
}

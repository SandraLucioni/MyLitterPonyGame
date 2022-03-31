package com.sandra.game.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Document(collection = "friends")
@Getter
@Setter
public class Friends {

    @Id
    @NotNull
    private String id;

    private String name;
    private int increment;
    private int friendshipBar;
}

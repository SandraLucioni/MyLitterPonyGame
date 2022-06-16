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
@Document(collection = "characters")
@Getter
@Setter
public class Characthers {

    @Id
    @NotNull
    private String id;

    private String description;
    private String name;
    private String photoProfile;
    private int position;

    private int increment;
    private int friendshipBar;

    public Characthers(String id, String description, String name, String photoProfile, int position) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.photoProfile = photoProfile;
        this.position = position;
    }

    public Characthers(String id, String name, int increment, int friendshipBar) {
        this.id = id;
        this.name = name;
        this.increment = increment;
        this.friendshipBar = friendshipBar;
    }

}

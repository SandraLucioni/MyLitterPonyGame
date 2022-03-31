package com.sandra.game.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "user_player")
@Getter
@Setter
public class UserPlayer {
    @Id
    @NotNull
    private String id;

    private String name;
    private Statistics statistics;
    private List<Decisions> decisionsList;
}

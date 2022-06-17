package com.sandra.game.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Document(collection = "gameStatus")
@Getter
@Setter
public class GameStatus {

    @Id
    @NotNull
    private String id;

    private boolean complete;
    private Decisions decisions;
    private Statistics statistics;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userCurrentIndex;
}

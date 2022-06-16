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
@Document(collection = "decisions")
@Getter
@Setter
public class Decisions {

    @Id
    @NotNull
    private String id;

    private String optionTextOne;
    private String optionTextTwo;
    private String optionTextThree;
    private String question;
}

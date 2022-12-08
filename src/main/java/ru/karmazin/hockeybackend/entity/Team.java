package ru.karmazin.hockeybackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Vladislav Karmazin
 */
@Entity
@Table(name = "Team")
@Getter
@Setter
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name should not be empty")
    private String name;

    public Team(String name) {
        this.name = name;
    }
}

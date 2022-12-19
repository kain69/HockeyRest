package ru.karmazin.hockeybackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Vladislav Karmazin
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Person shouldn`t be null")
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;

    @NotNull(message = "Number shouldn`t be null")
    private int number;

    @NotNull(message = "Role shouldn`t be null")
    private PlayerRole role;

    public Player(Person person, Team team, int number, PlayerRole role) {
        this.person = person;
        this.team = team;
        this.number = number;
        this.role = role;
    }
}

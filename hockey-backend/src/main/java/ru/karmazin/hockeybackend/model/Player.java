package ru.karmazin.hockeybackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Vladislav Karmazin
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "player")
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
    private Team team;

    @NotNull(message = "Number shouldn`t be null")
    private int number;

    @NotNull(message = "Role shouldn`t be null")
    @Enumerated(EnumType.STRING)
    private PlayerRole role;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApprovedPlayer> approvedPlayers;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlayerLine> playerLines;

    public Player(Person person, Team team, int number, PlayerRole role) {
        this.person = person;
        this.team = team;
        this.number = number;
        this.role = role;
    }
}

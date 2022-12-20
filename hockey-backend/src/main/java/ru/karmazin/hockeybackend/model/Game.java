package ru.karmazin.hockeybackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Vlad Karmazin
 */
@Entity
@Table(name = "game")
@Data
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    private LocalDate date;

    private String opponent;

    private Boolean isWon;

    private int teamResult;

    private int opponentResult;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "game_line",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "line_id"))
    private List<Line> lines;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApprovedPlayer> approvedPlayers;

    public Game(Team team, Place place, LocalDate date, String opponent, Boolean isWon, int teamResult, int opponentResult) {
        this.team = team;
        this.place = place;
        this.date = date;
        this.opponent = opponent;
        this.isWon = isWon;
        this.teamResult = teamResult;
        this.opponentResult = opponentResult;
    }
}

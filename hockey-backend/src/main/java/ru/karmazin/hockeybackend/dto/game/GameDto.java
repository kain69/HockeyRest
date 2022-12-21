package ru.karmazin.hockeybackend.dto.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vlad Karmazin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDto {
    private int id;
    private String team;
    private String opponent;
    private String place;
    private String date;
    private int teamResult;
    private int opponentResult;
    private Boolean isWon;
}

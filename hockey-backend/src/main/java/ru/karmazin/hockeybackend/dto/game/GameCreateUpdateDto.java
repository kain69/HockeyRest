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
public class GameCreateUpdateDto {
    private int team_id;
    private String opponent;
    private int place_id;
    private String date;
    private int teamResult;
    private int opponentResult;
    private Boolean isWon;
}

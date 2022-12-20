package ru.karmazin.hockeybackend.dto.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.karmazin.hockeybackend.dto.approvedPlayer.ApprovedPlayerDto;
import ru.karmazin.hockeybackend.dto.line.LineDto;
import ru.karmazin.hockeybackend.dto.team.SimpleTeamDto;
import ru.karmazin.hockeybackend.model.Place;

import java.util.List;

/**
 * @author Vlad Karmazin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDto {
    private int id;
    private SimpleTeamDto simpleTeamDto;
    private String opponent;
    private Place place;
    private String date;
    private int teamResult;
    private int opponentResult;
    private Boolean isWon;
    private List<LineDto> lineDtos;
    private List<ApprovedPlayerDto> approvedPlayerDtos;
}

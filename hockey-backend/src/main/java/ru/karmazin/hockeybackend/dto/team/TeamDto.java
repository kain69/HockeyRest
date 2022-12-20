package ru.karmazin.hockeybackend.dto.team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.karmazin.hockeybackend.dto.game.GameDto;
import ru.karmazin.hockeybackend.dto.line.LineDto;
import ru.karmazin.hockeybackend.dto.player.PlayerDto;

import java.util.List;

/**
 * @author Vlad Karmazin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {
    private int id;
    private String name;
    private List<PlayerDto> playerDtos;
    private List<GameDto> gameDtos;
    private List<LineDto> lines;
}

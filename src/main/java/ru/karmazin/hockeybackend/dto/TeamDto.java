package ru.karmazin.hockeybackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.karmazin.hockeybackend.model.Player;

import java.util.List;

/**
 * @author Vladislav Karmazin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    private int id;
    private String name;
    private List<Player> players;
}

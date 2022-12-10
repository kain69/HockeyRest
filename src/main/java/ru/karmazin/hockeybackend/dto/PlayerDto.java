package ru.karmazin.hockeybackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.karmazin.hockeybackend.model.PlayerRole;

/**
 * @author Vladislav Karmazin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
    private int id;
    private SimplePersonDto person;
    private int number;
    private PlayerRole role;
}

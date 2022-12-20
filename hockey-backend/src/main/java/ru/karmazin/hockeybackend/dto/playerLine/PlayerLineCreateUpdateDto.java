package ru.karmazin.hockeybackend.dto.playerLine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.karmazin.hockeybackend.dto.player.PlayerDto;

/**
 * @author Vlad Karmazin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerLineCreateUpdateDto {
    private int position;
    private PlayerDto playerDto;
}

package ru.karmazin.hockeybackend.dto.approvedPlayer;

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
public class ApprovedPlayerDto {
    private PlayerDto playerDto;
    private boolean isReady;
}

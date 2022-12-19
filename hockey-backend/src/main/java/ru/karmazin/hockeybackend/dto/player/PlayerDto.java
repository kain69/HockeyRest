package ru.karmazin.hockeybackend.dto.player;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.karmazin.hockeybackend.dto.person.SimplePersonDto;
import ru.karmazin.hockeybackend.model.PlayerRole;

/**
 * @author Vladislav Karmazin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Игрок")
public class PlayerDto {
    @Schema(description = "Идентификатор")
    private int id;
    @Schema(description = "Человек")
    private SimplePersonDto person;
    @Schema(description = "Номер")
    private int number;
    @Schema(description = "Роль")
    private PlayerRole role;
}

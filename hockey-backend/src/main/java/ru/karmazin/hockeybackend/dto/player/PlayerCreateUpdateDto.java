package ru.karmazin.hockeybackend.dto.player;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.karmazin.hockeybackend.model.PlayerRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Игрок")
public class PlayerCreateUpdateDto {
    @Schema(description = "Идентификатор человека")
    private Integer personId;
    @Schema(description = "Номер")
    private int number;
    @Schema(description = "Роль")
    private PlayerRole role;
}

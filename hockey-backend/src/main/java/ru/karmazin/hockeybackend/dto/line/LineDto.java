package ru.karmazin.hockeybackend.dto.line;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.karmazin.hockeybackend.dto.playerLine.PlayerLineDto;

import java.util.List;

/**
 * @author Vlad Karmazin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineDto {
    private int id;
    private String name;
    private List<PlayerLineDto> playerLineDtoList;
}

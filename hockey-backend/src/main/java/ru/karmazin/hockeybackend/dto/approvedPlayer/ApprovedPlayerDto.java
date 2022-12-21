package ru.karmazin.hockeybackend.dto.approvedPlayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Vlad Karmazin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprovedPlayerDto {
    private int id;
    private int player_id;
    private String name;
    private String surname;
    private int number;
    private boolean isReady;
}

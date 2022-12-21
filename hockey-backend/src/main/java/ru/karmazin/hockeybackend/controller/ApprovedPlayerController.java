package ru.karmazin.hockeybackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vlad Karmazin
 */
@RestController
@RequestMapping("/api/teams/{id}/games/{id}/approvedPlayers")
@RequiredArgsConstructor
public class ApprovedPlayerController {

}

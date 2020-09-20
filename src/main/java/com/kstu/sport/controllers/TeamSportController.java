package com.kstu.sport.controllers;

import com.kstu.sport.persistence.dto.TeamSportEventDto;
import com.kstu.sport.services.TeamSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeamSportController {

    @Autowired
    TeamSportService teamSportService;

    @PostMapping("/teamSportEvent/add")
    public HttpStatus addTeamSportEvent(@RequestBody TeamSportEventDto teamSportEventDto){
        teamSportService.addTeamSportEvent(teamSportEventDto);
        return HttpStatus.OK;
    }

    @GetMapping("/teamSportEvent/getList")
    public List<TeamSportEventDto> getPage(){

        return teamSportService.getTeamSportEventList();
    }

}

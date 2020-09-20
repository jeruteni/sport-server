package com.kstu.sport.services;

import com.kstu.sport.persistence.dto.TeamSportEventDto;

import java.util.List;

public interface TeamSportService {

    void addTeamSportEvent(TeamSportEventDto teamSportEventDto);

    List<TeamSportEventDto> getTeamSportEventList();

}

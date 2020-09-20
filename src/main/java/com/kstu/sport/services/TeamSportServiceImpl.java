package com.kstu.sport.services;

import com.kstu.sport.persistence.dao.TeamSportEventRepository;
import com.kstu.sport.persistence.domain.TeamSportEvent;
import com.kstu.sport.persistence.dto.TeamSportEventDto;
import com.kstu.sport.services.mapping.TeamSportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamSportServiceImpl implements TeamSportService {

    @Autowired
    TeamSportEventRepository teamSportEventRepository;
    @Autowired
    TeamSportMapper teamSportMapper;

    @Override
    public void addTeamSportEvent(TeamSportEventDto teamSportEventDto) {

        TeamSportEvent teamSportEvent = teamSportMapper.mapToEntity(teamSportEventDto);
        teamSportEventRepository.save(teamSportEvent);

    }

    @Override
    public List<TeamSportEventDto> getTeamSportEventList() {

        List <TeamSportEvent> teamSportEventList = teamSportEventRepository.findAll();

        List <TeamSportEventDto> teamSportEventDtoList = new ArrayList<>();

        for (TeamSportEvent teamSportEvent : teamSportEventList){

            TeamSportEventDto teamSportEventDto = teamSportMapper.mapToDto(teamSportEvent);
            teamSportEventDtoList.add(teamSportEventDto);
        }

        return teamSportEventDtoList;
    }


}

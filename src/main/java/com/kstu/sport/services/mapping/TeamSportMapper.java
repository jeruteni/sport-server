package com.kstu.sport.services.mapping;

import com.kstu.sport.persistence.dao.CustomerRepository;
import com.kstu.sport.persistence.dao.SportsCategoryRepository;
import com.kstu.sport.persistence.domain.TeamSportEvent;
import com.kstu.sport.persistence.dto.TeamSportEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class TeamSportMapper {

    @Autowired
    SportsCategoryRepository sportsCategoryRepository;
    @Autowired
    CustomerRepository customerRepository;

    public TeamSportEvent mapToEntity(TeamSportEventDto teamSportEventDto){

        TeamSportEvent teamSportEvent = new TeamSportEvent();

        teamSportEvent.setFirstTeamName(teamSportEventDto.getFirstTeamName());
        teamSportEvent.setSecondTeamName(teamSportEventDto.getSecondTeamName());
        teamSportEvent.setFirstTeamLineUp(teamSportEventDto.getFirstTeamLineUp());
        teamSportEvent.setSecondTeamLineUp(teamSportEventDto.getSecondTeamLineUp());
        teamSportEvent.setName(teamSportEventDto.getName());
        teamSportEvent.setAudienceCount(teamSportEventDto.getAudienceCount());
        teamSportEvent.setSportsCategory(sportsCategoryRepository.findByCategoryId(teamSportEventDto.getSportsCategoryID()));
        teamSportEvent.setCity(teamSportEventDto.getCity());
        teamSportEvent.setCustomer(customerRepository.getOne(teamSportEventDto.getCustomerId()));

        return teamSportEvent;
    }

    public TeamSportEventDto mapToDto(TeamSportEvent teamSportEvent){

        TeamSportEventDto teamSportEventDto = new TeamSportEventDto();

        teamSportEventDto.setFirstTeamName(teamSportEvent.getFirstTeamName());
        teamSportEventDto.setSecondTeamName(teamSportEvent.getSecondTeamName());
        teamSportEventDto.setFirstTeamLineUp(teamSportEvent.getFirstTeamLineUp());
        teamSportEventDto.setSecondTeamLineUp(teamSportEvent.getSecondTeamLineUp());
        teamSportEventDto.setName(teamSportEvent.getName());
        teamSportEventDto.setAudienceCount(teamSportEvent.getAudienceCount());
        teamSportEventDto.setCity(teamSportEvent.getCity());
        teamSportEventDto.setSportsCategoryID(teamSportEvent.getSportsCategory().getCategoryId());
        teamSportEventDto.setCustomerId(teamSportEvent.getCustomer().getId());

        return teamSportEventDto;
    }
}

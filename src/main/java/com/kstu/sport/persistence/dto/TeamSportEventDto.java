package com.kstu.sport.persistence.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamSportEventDto extends SportEventDto {

    private String firstTeamName;
    private String secondTeamName;

    private List <String> firstTeamLineUp;
    private List <String> secondTeamLineUp;

    private Long customerId;
}

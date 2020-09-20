package com.kstu.sport.persistence.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;


@Entity
@Data
@Table(name = "teamSport_event")
public class TeamSportEvent extends SportEvent {

    @Column(name = "firstTeamName",nullable = false)
    private String firstTeamName;
    @Column(name = "secondTeamName",nullable = false)
    private String secondTeamName;

    @Column(name = "firstTeamLineUp")
    @ElementCollection(targetClass = String.class)
    private List<String> firstTeamLineUp;

    @Column(name = "secondTeamLineUp")
    @ElementCollection(targetClass = String.class)
    private List<String> secondTeamLineUp;

}

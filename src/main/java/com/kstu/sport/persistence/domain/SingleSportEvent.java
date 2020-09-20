package com.kstu.sport.persistence.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "singleSport_event")
public class SingleSportEvent extends SportEvent{

    private String firstSportsmanName;
    private String secondSportsmanName;
}

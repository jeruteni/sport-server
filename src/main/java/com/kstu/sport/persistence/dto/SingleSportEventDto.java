package com.kstu.sport.persistence.dto;

import lombok.Data;

@Data
public class SingleSportEventDto extends SportEventDto {

    private String firstSportsmanName;
    private String secondSportsmanName;

    private Long customerId;

}

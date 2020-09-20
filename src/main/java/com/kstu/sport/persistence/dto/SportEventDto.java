package com.kstu.sport.persistence.dto;

import lombok.Data;

@Data
public abstract class SportEventDto extends LongIdEntityDto {

    private String name;
    private int audienceCount;
    private String city;
    private int sportsCategoryID;

}


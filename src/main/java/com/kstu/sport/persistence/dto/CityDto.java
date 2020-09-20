package com.kstu.sport.persistence.dto;

public class CityDto extends LongIdEntityDto {

    private String caption;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}

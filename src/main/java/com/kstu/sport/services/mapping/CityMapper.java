package com.kstu.sport.services.mapping;

import com.kstu.sport.persistence.domain.City;
import com.kstu.sport.persistence.dto.CityDto;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    public CityDto mapToDto(City city) {
        CityDto cityDto = new CityDto();

        cityDto.setId(
                city.getId()
        );
        cityDto.setCaption(
                city.getCaption()
        );

        return cityDto;
    }

    public City mapToEntity(CityDto cityDto) {
        City city = new City();

        city.setId(
                cityDto.getId()
        );
        city.setCaption(
                cityDto.getCaption()
        );

        return city;
    }

}

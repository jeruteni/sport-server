package com.kstu.sport.services.mapping;

import com.kstu.sport.persistence.domain.Event;
import com.kstu.sport.persistence.dto.EventProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private SportsComplexMapper sportsComplexMapper;

    public EventProfileDto mapToDto(Event event) {
        EventProfileDto eventProfileDto = new EventProfileDto();

        eventProfileDto.setId(
                event.getId()
        );
        eventProfileDto.setEventDate(
                event.getEventDate()
        );
        eventProfileDto.setEventTime(
                event.getEventTime()
        );
        eventProfileDto.setDescription(
                event.getDescription()
        );
        eventProfileDto.setName(
                event.getName()
        );
        eventProfileDto.setAgeFrom(
                event.getAgeFrom()
        );
        eventProfileDto.setAgeTo(
                event.getAgeTo()
        );
        eventProfileDto.setForm(
                event.getForm()
        );
        eventProfileDto.setPlace(
                event.getPlace()
        );
        eventProfileDto.setType(
                event.getType()
        );

        if (event.getSportsCategory() != null) {
            eventProfileDto.setCategoryDto(
                    categoryMapper.mapToDto(event.getSportsCategory())
            );
        }

        if (event.getSportsComplex() != null) {
            eventProfileDto.setSportsComplexDto(
                    sportsComplexMapper.mapToDto(event.getSportsComplex())
            );
        }


        return eventProfileDto;
    }
}

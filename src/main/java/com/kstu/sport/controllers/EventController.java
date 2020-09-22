package com.kstu.sport.controllers;

import com.kstu.sport.persistence.dao.CategoryRepository;
import com.kstu.sport.persistence.dao.EventRepository;
import com.kstu.sport.persistence.dao.SportsComplexRepository;
import com.kstu.sport.persistence.domain.Event;
import com.kstu.sport.persistence.domain.SportsCategory;
import com.kstu.sport.persistence.domain.SportsComplex;
import com.kstu.sport.persistence.dto.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class EventController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SportsComplexRepository sportsComplexRepository;

    @Autowired
    private EventRepository eventRepository;

    @PostMapping("events/saveStepOne")
    public Long saveStepOne(@RequestBody EventDto eventDto) {
        Event event = new Event();

        Optional<SportsComplex> complex = sportsComplexRepository.findById(eventDto.getComplex());

        if (!complex.isPresent()) {
            throw new IllegalArgumentException("Данного комплекса с таким id не существует");
        }
        event.setSportsComplex(
                complex.get()
        );

        Optional<SportsCategory> sportsCategory = categoryRepository.findByCategoryId(eventDto.getSportType());

        if (!sportsCategory.isPresent()) {
            throw new IllegalArgumentException("Данного комплекса с таким id не существует");
        }
        event.setSportsCategory(
                sportsCategory.get()
        );


        event.setEventDate(
                eventDto.getEventDate()
        );
        event.setEventTime(
                eventDto.getEventTime()
        );

        eventRepository.save(event);

        return event.getId();
    }

    @PostMapping("events/saveStepTwo")
    public void saveStepTwo(@RequestBody EventDto eventDto) {
        Optional<Event> event = eventRepository.findById(eventDto.getId());

        if (!event.isPresent()) {
            throw new IllegalArgumentException("Мероприятия с данным id нет");
        }

        event.get().setDescription(
                eventDto.getDescription()
        );
        event.get().setName(
                eventDto.getName()
        );

        eventRepository.save(event.get());
    }

    @PostMapping
    public void saveStepThree(@RequestBody EventDto eventDto) {
        Optional<Event> eventOptional = eventRepository.findById(eventDto.getId());

        if (!eventOptional.isPresent()) {
            throw new IllegalArgumentException("Мероприятия с данным id нет");
        }
        Event event = eventOptional.get();

        event.setAgeFrom(
                eventDto.getAgeFrom()
        );
        event.setAgeTo(
                eventDto.getAgeTo()
        );
        event.setForm(
                eventDto.getForm()
        );
        event.setPlace(
                eventDto.getPlace()
        );
        event.setType(
                eventDto.getType()
        );

        eventRepository.save(event);
    }
}

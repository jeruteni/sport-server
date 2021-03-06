package com.kstu.sport.controllers;

import com.kstu.sport.persistence.dao.*;
import com.kstu.sport.persistence.domain.*;
import com.kstu.sport.persistence.dto.EventDto;
import com.kstu.sport.persistence.dto.EventProfileDto;
import com.kstu.sport.services.MailService;
import com.kstu.sport.services.mail.MailSender;
import com.kstu.sport.services.mapping.AccountMapper;
import com.kstu.sport.services.mapping.CategoryMapper;
import com.kstu.sport.services.mapping.SportsComplexMapper;
import com.kstu.sport.util.Constraints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class EventController {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SportsComplexRepository sportsComplexRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private SportsComplexMapper sportsComplexMapper;

    @Autowired
    private MailService mailService;


    @PostMapping("events/saveStepOne")
    public Long saveStepOne(@RequestBody EventDto eventDto) {
        Event event = new Event();

        Optional<Account> account = accountRepository.findById(eventDto.getAccountId() );

        if (!account.isPresent()) {
            throw new IllegalArgumentException("Пользователя с таким id не найден");
        }


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
        event.setAccount(
                account.get()
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

    @PostMapping("events/saveStepThree")
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

        //mailService.mailingPreferences(event);

    }

    @GetMapping("/events/findById")
    public EventProfileDto getEventById(@RequestParam(name = "eventId") Long eventId) {

        Optional<Event> byId = eventRepository.findById(eventId);
        if (byId.isPresent()) {
            return mapToDto(byId.get());
        }
        throw new IllegalArgumentException("Мероприятия с данным id не существует");
    }

    @GetMapping("/events/fetchAll")
    public List<EventProfileDto> getAllEvents() {
        List<Event> data = eventRepository.findAll();
        return data.stream().map(this::mapToDto).collect(Collectors.toList());

    }

    private EventProfileDto mapToDto(Event event) {
        EventProfileDto eventProfileDto = new EventProfileDto();

        eventProfileDto.setAccountId(
                event.getAccount().getId()
        );
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

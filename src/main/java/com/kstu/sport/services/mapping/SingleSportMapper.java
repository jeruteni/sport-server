package com.kstu.sport.services.mapping;

import com.kstu.sport.persistence.dao.CustomerRepository;
import com.kstu.sport.persistence.dao.SportsCategoryRepository;
import com.kstu.sport.persistence.domain.SingleSportEvent;
import com.kstu.sport.persistence.dto.SingleSportEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingleSportMapper {

    @Autowired
    SportsCategoryRepository sportsCategoryRepository;
    @Autowired
    CustomerRepository customerRepository;

    public SingleSportEvent mapToEntity (SingleSportEventDto singleSportEventDto){

        SingleSportEvent singleSportEvent = new SingleSportEvent();

        singleSportEvent.setFirstSportsmanName(singleSportEventDto.getFirstSportsmanName());
        singleSportEvent.setSecondSportsmanName(singleSportEventDto.getSecondSportsmanName());
        singleSportEvent.setAudienceCount(singleSportEventDto.getAudienceCount());
        singleSportEvent.setCity(singleSportEventDto.getCity());
        singleSportEvent.setName(singleSportEventDto.getName());
        singleSportEvent.setSportsCategory(sportsCategoryRepository.findByCategoryId(singleSportEventDto.getSportsCategoryID()));
        singleSportEvent.setCustomer(customerRepository.getOne(singleSportEventDto.getCustomerId()));

        return singleSportEvent;
    }

    public SingleSportEventDto mapToDto(SingleSportEvent singleSportEvent){

        SingleSportEventDto singleSportEventDto = new SingleSportEventDto();
        singleSportEventDto.setFirstSportsmanName(singleSportEvent.getFirstSportsmanName());
        singleSportEventDto.setSecondSportsmanName(singleSportEvent.getSecondSportsmanName());
        singleSportEventDto.setAudienceCount(singleSportEvent.getAudienceCount());
        singleSportEventDto.setCity(singleSportEvent.getCity());
        singleSportEventDto.setName(singleSportEvent.getName());
        singleSportEventDto.setSportsCategoryID(singleSportEvent.getSportsCategory().getCategoryId());
        singleSportEventDto.setCustomerId(singleSportEvent.getCustomer().getId());

        return singleSportEventDto;
    }

}

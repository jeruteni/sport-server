package com.kstu.sport.services;

import com.kstu.sport.persistence.domain.SingleSportEvent;
import com.kstu.sport.persistence.dto.SingleSportEventDto;

import java.util.List;

public interface SingleSportService {

    void addSingleSportEvent(SingleSportEventDto singleSportEventDto);

    List<SingleSportEventDto> getSingleSportEventList();

}

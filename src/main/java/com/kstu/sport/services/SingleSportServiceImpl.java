package com.kstu.sport.services;

import com.kstu.sport.persistence.dao.SingleSportEventRepository;
import com.kstu.sport.persistence.domain.SingleSportEvent;
import com.kstu.sport.persistence.dto.SingleSportEventDto;
import com.kstu.sport.services.mapping.SingleSportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SingleSportServiceImpl implements SingleSportService {

    @Autowired
    SingleSportEventRepository singleSportEventRepository;
    @Autowired
    SingleSportMapper singleSportMapper;

    @Override
    public void addSingleSportEvent(SingleSportEventDto singleSportEventDto) {
        SingleSportEvent singleSportEvent = singleSportMapper.mapToEntity(singleSportEventDto);
        singleSportEventRepository.save(singleSportEvent);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SingleSportEventDto> getSingleSportEventList() {

        List <SingleSportEvent> singleSportEventList = singleSportEventRepository.findAll();

        List <SingleSportEventDto> singleSportEventsDtoList = new ArrayList<>();

        for (SingleSportEvent singleSportEvent : singleSportEventList){

            SingleSportEventDto singleSportEventDto = singleSportMapper.mapToDto(singleSportEvent);
            singleSportEventsDtoList.add(singleSportEventDto);

        }
        return singleSportEventsDtoList;
    }
}

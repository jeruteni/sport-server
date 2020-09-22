package com.kstu.sport.controllers;

import com.kstu.sport.persistence.dao.EventRepository;
import com.kstu.sport.persistence.dao.SportsComplexRepository;
import com.kstu.sport.persistence.domain.Event;
import com.kstu.sport.persistence.domain.SportsComplex;
import com.kstu.sport.persistence.dto.EventProfileDto;
import com.kstu.sport.persistence.dto.GeoPointDto;
import com.kstu.sport.services.mapping.EventMapper;
import com.kstu.sport.services.mapping.SportsComplexMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class NearestComplexController {

    @Autowired
    SportsComplexRepository sportsComplexRepository;
    @Autowired
    SportsComplexMapper sportsComplexMapper;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventMapper eventMapper;

//    @PostMapping("/getNearestSportComplex")
//    public SportsComplexDto searchNearestComplex(@RequestBody GeoPointDto geoPointDto){
//
//        //SportsComplex sportsComplex = getNearestSportComplex(geoPointDto);
//
//        return sportsComplexMapper.mapToDto(sportsComplex);
//    }


    @PostMapping("/events/fetchAllByGeoPoint")
    private List<EventProfileDto> sortComplexByNearGeoPosition(@RequestBody GeoPointDto geoPointDto) {
        List<EventProfileDto>  sortedList = new ArrayList<>();

        List<SportsComplex> sportsComplexList = sportsComplexRepository.findAll();

        while (CollectionUtils.isNotEmpty(sportsComplexList)) {
            SportsComplex nearestComplex = getNearestSportComplex(geoPointDto,sportsComplexList);
            List<Event> data = eventRepository.findBySportsComplex(nearestComplex);

            sortedList.addAll(data.stream().map(e -> eventMapper.mapToDto(e)).collect(Collectors.toList()));
            sportsComplexList.remove(nearestComplex);
        }

        return sortedList;
    }

    private SportsComplex getNearestSportComplex(GeoPointDto geoPointDto,List<SportsComplex> sportsComplexList){
//        List<SportsComplex> sportsComplexList = sportsComplexRepository.findAll();

        double minDistance = Double.MAX_VALUE;
        SportsComplex nearestSportComplex = new SportsComplex();

        for(SportsComplex sportsComplex : sportsComplexList){

            double lat2 = Double.parseDouble(geoPointDto.getLatitude());
            double lat1= sportsComplex.getGeoPoint().getLatitude().doubleValue();
            double lon1= sportsComplex.getGeoPoint().getLongitude().doubleValue();
            double lon2= Double.parseDouble(geoPointDto.getLongitude());
            double distance = distance(lat2, lat1, lon1, lon2);

            if(distance < minDistance){
                minDistance = distance;
                nearestSportComplex = sportsComplex;
            }

        }

        return nearestSportComplex;
    }

    private double distance(double lat2, double lat1, double lon1, double lon2){

        double p = 0.017453292519943295;    // Math.PI / 180

        double a = 0.5 - Math.cos((lat2 - lat1) * p)/2 +
                Math.cos(lat1 * p) * Math.cos(lat2 * p) *
                        (1 - Math.cos((lon2 - lon1) * p))/2;

        return 12742 * Math.asin(Math.sqrt(a));
    }
}

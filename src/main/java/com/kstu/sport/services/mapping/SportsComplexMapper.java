package com.kstu.sport.services.mapping;

import com.kstu.sport.persistence.domain.GeoPoint;
import com.kstu.sport.persistence.domain.SportsComplex;
import com.kstu.sport.persistence.dto.GeoPointDto;
import com.kstu.sport.persistence.dto.SportsComplexDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

@Component
public class SportsComplexMapper {

    @Autowired
    private CityMapper cityMapper;

    public SportsComplexDto mapToDto(SportsComplex sportsComplex) {
        SportsComplexDto sportsComplexDto = new SportsComplexDto();

        sportsComplexDto.setId(
                sportsComplex.getId()
        );
        sportsComplexDto.setCaption(
                sportsComplex.getCaption()
        );
        sportsComplexDto.setPhoneNumber(
                sportsComplex.getPhoneNumber()
        );
        sportsComplexDto.setAddress(
                sportsComplex.getAddress()
        );
        sportsComplexDto.setCity(
                cityMapper.mapToDto(sportsComplex.getCity())
        );

        if (Objects.nonNull(sportsComplex.getGeoPoint())) {
            GeoPoint geoPoint = sportsComplex.getGeoPoint();
            // TODO без нормаального типа буду отдавать им стрингой.Возможны NPE
            try {
                sportsComplexDto.setGeoPoint(new GeoPointDto(geoPoint.getLatitude().toString(), geoPoint.getLongitude().toString()));
            } catch (NullPointerException e) {
                throw new IllegalArgumentException("Спортивный комплекс должен иметь две координаты в geoPoint");
            }

        }

        return sportsComplexDto;
    }

    public SportsComplex mapToEntity(SportsComplexDto sportsComplexDto) {
        SportsComplex sportsComplex = new SportsComplex();

        sportsComplex.setId(
                sportsComplexDto.getId()
        );
        sportsComplex.setCaption(
                sportsComplexDto.getCaption()
        );
        sportsComplex.setPhoneNumber(
                sportsComplexDto.getPhoneNumber()
        );
        sportsComplex.setAddress(
                sportsComplexDto.getAddress()
        );
        sportsComplex.setCity(
                cityMapper.mapToEntity(sportsComplexDto.getCity())
        );

        if (Objects.nonNull(sportsComplexDto.getGeoPoint())) {
            GeoPointDto geoPointDto = sportsComplexDto.getGeoPoint();
            // TODO ужасно,исправить
            try {
                sportsComplex.setGeoPoint(new GeoPoint(new BigDecimal(geoPointDto.getLatitude()), new BigDecimal(geoPointDto.getLongitude())));
            } catch (NullPointerException e) {
                throw new IllegalArgumentException("Спортивный комплекс должен иметь две координаты в geoPoint");
            }
        }
        return sportsComplex;
    }

}

package com.kstu.sport.services;

import com.kstu.sport.persistence.dto.CityDto;

import java.util.List;

public interface CityService {

    List<CityDto> fetchAllCities();

}

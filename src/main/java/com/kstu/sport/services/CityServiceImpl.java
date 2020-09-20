package com.kstu.sport.services;

import com.kstu.sport.persistence.dao.CityRepository;
import com.kstu.sport.persistence.domain.City;
import com.kstu.sport.persistence.dto.CityDto;
import com.kstu.sport.services.mapping.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CityMapper cityMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CityDto> fetchAllCities() {
        List<City> data = cityRepository.findAll();
        return data.stream().map(e -> cityMapper.mapToDto(e)).collect(Collectors.toList());
    }
}

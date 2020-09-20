package com.kstu.sport.controllers;

import com.kstu.sport.persistence.dto.CityDto;
import com.kstu.sport.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("city/fetchAll")
    public List<CityDto> fetchAll() {
        return cityService.fetchAllCities();
    }
}

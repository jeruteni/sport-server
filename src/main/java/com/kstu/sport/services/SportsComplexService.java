package com.kstu.sport.services;

import com.kstu.sport.persistence.dto.SportsComplexDto;

import java.util.List;

public interface SportsComplexService {

    List<SportsComplexDto> fetchAll();

    void submit(SportsComplexDto sportsComplexDto);

}

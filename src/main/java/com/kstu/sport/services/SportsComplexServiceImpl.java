package com.kstu.sport.services;

import com.kstu.sport.persistence.dao.SportsComplexRepository;
import com.kstu.sport.persistence.domain.SportsComplex;
import com.kstu.sport.persistence.dto.SportsComplexDto;
import com.kstu.sport.services.mapping.SportsComplexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportsComplexServiceImpl implements SportsComplexService {
    @Autowired
    private SportsComplexRepository sportsComplexRepository;

    @Autowired
    private SportsComplexMapper sportsComplexMapper;

    @Override
    @Transactional(readOnly = true)
    public List<SportsComplexDto> fetchAll() {
        List<SportsComplex> data = sportsComplexRepository.findAll();
        return data.stream().map(s -> sportsComplexMapper.mapToDto(s)).collect(Collectors.toList());
    }

    @Override
    public void submit(SportsComplexDto sportsComplexDto) {
        //TODO сделать проверку на существование и реализовать как update тоже
        sportsComplexRepository.save(sportsComplexMapper.mapToEntity(sportsComplexDto));
    }

}

package com.kstu.sport.controllers;

import com.kstu.sport.persistence.dto.SportsComplexDto;
import com.kstu.sport.services.SportsComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class SportsComplexController {
    @Autowired
    private SportsComplexService sportsComplexService;

    @GetMapping("/complex/fetchAll")
    public List<SportsComplexDto> fetchAll() {
        return sportsComplexService.fetchAll();
    }

    @PostMapping("/complex/submit")
    public void submit(@RequestBody SportsComplexDto sportsComplexDto) {
        sportsComplexService.submit(sportsComplexDto);
    }

}

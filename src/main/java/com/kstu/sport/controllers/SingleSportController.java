package com.kstu.sport.controllers;

import com.kstu.sport.persistence.dto.SingleSportEventDto;
import com.kstu.sport.services.SingleSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class SingleSportController {

    @Autowired
    SingleSportService singleSportService;

    @PostMapping("/singleSportEvent/add")
    public HttpStatus addTeamSportEvent(@RequestBody SingleSportEventDto singleSportEventDto){
        singleSportService.addSingleSportEvent(singleSportEventDto);
        return HttpStatus.OK;
    }

    @GetMapping("/singleSportEvent/getList")
    public List<SingleSportEventDto> getPage(){

        return singleSportService.getSingleSportEventList();
    }

}


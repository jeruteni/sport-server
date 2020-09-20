package com.kstu.sport.controllers;

import com.kstu.sport.persistence.dto.CustomerDto;
import com.kstu.sport.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customer/add")
    public HttpStatus addTeamSportEvent(@RequestBody CustomerDto customerDto){
        customerService.addCustomer(customerDto);
        return HttpStatus.OK;
    }

}

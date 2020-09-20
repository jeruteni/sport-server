package com.kstu.sport.services.mapping;

import com.kstu.sport.persistence.dao.AccountRepository;
import com.kstu.sport.persistence.domain.Customer;
import com.kstu.sport.persistence.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    @Autowired
    AccountRepository accountRepository;

    public Customer mapToEntity (CustomerDto customerDto){

        Customer customer = new Customer();

        customer.setCaption(customerDto.getCaption());
        customer.setAccount(accountRepository.findByIdEquals(customerDto.getAccountId()));

        return customer;

    }

    public CustomerDto mapToDto(Customer customer){

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCaption(customer.getCaption());
        customerDto.setAccountId(customer.getAccount().getId());

        return customerDto;
    }

}

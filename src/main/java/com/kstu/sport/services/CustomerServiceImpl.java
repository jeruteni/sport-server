package com.kstu.sport.services;

import com.kstu.sport.persistence.dao.CustomerRepository;
import com.kstu.sport.persistence.domain.Customer;
import com.kstu.sport.persistence.dto.CustomerDto;
import com.kstu.sport.services.mapping.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public void addCustomer(CustomerDto customerDto) {

        Customer customer = customerMapper.mapToEntity(customerDto);
        customerRepository.save(customer);

    }

}

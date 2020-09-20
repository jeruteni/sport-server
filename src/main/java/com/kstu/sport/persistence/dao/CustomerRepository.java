package com.kstu.sport.persistence.dao;

import com.kstu.sport.persistence.domain.Account;
import com.kstu.sport.persistence.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findAllByAccount(Account account);
}

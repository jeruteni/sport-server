package com.kstu.sport.persistence.dao;

import com.kstu.sport.persistence.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

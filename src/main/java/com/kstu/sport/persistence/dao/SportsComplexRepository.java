package com.kstu.sport.persistence.dao;

import com.kstu.sport.persistence.domain.SportsComplex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsComplexRepository extends JpaRepository<SportsComplex, Long> {
    Long countByCaption(String caption);
}

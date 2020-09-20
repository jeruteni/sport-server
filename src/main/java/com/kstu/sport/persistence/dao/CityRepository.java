package com.kstu.sport.persistence.dao;

import com.kstu.sport.persistence.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

    Boolean existsByCaption(String caption);

}

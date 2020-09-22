package com.kstu.sport.persistence.dao;

import com.kstu.sport.persistence.domain.Event;
import com.kstu.sport.persistence.domain.SportsComplex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event,Long> {
    public List<Event> findBySportsComplex(SportsComplex complex);
}

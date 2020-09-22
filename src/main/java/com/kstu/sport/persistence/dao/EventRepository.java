package com.kstu.sport.persistence.dao;

import com.kstu.sport.persistence.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}

package com.kstu.sport.persistence.dao;

import com.kstu.sport.persistence.domain.SingleSportEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleSportEventRepository extends JpaRepository<SingleSportEvent, Long> {

}

package com.kstu.sport.persistence.dao;

import com.kstu.sport.persistence.domain.SportsCategory;
import com.kstu.sport.persistence.domain.TeamSportEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamSportEventRepository extends JpaRepository<TeamSportEvent,Long> {
}

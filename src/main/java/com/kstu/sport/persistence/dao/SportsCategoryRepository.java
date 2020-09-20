package com.kstu.sport.persistence.dao;

import com.kstu.sport.persistence.domain.SportsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsCategoryRepository extends JpaRepository<SportsCategory,Long> {

    SportsCategory findByCategoryId(int categoryId);
}

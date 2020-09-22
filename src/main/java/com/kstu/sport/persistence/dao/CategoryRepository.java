package com.kstu.sport.persistence.dao;

import com.kstu.sport.persistence.domain.SportsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<SportsCategory,Long> {
    Optional<SportsCategory> findByCategoryId(Long categoryId);
}

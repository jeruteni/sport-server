package com.kstu.sport.persistence.dao;

import com.kstu.sport.persistence.domain.AccountPreferences;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountPreferencesRepository extends JpaRepository<AccountPreferences, Long> {
}

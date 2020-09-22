package com.kstu.sport.persistence.dao;

import com.kstu.sport.persistence.domain.AccountPreferences;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountPreferencesRepository extends JpaRepository<AccountPreferences, Long> {
    AccountPreferences findByAccountIdAndSportsCategoryId(Long accountId,Long categoryId);
    Long countAccountPreferencesByAccountIdAndSportsCategoryId(Long accountId,Long categoryId);
    List<AccountPreferences> findAccountPreferencesBySportsCategoryId(Long categoryId);
}

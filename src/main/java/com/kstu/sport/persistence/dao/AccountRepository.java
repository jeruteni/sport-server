package com.kstu.sport.persistence.dao;

import com.kstu.sport.persistence.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByEmail(String email);

    Account findByIdEquals (Long Id);

    //TODO обязательно сделать поиск независимо от регистра.Мб можно сделать через репу,
    // на крайняк criteriaApi или sql @Query
    Long countAccountByEmail(String email);
}

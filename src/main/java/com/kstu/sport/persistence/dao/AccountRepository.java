package com.kstu.sport.persistence.dao;

import com.kstu.sport.persistence.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByEmail(String email);

    Long countAccountByEmail(String email);
}

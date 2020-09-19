package com.kstu.sport.services;

import com.kstu.sport.persistence.domain.Account;
import com.kstu.sport.persistence.dto.AccountDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface AccountService {

    // Сохранение и обновление пользователя(нужно красиво написать чтоб обновлялся.Либо выносить в два разных метода)
    void submit(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    UserDetails createUserDetails(Account account);

    Account findByEmail(String email);

    void register(AccountDto accountDto);

    boolean checkAccountForExistsByEmail(String email);
}

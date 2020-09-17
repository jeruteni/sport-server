package com.kstu.sport.services;

import com.kstu.sport.persistence.domain.Account;
import com.kstu.sport.persistence.dto.AccountDto;
import org.springframework.stereotype.Component;

//Пока тупо методы мапинга писать из дто в сущность и обратно.Потом можно интерфейс определить и по красоте делать
@Component
public class UserMapper {

    public Account mapToEntity(AccountDto accountDto) {
        Account account = new Account();

        account.setLogin(
                accountDto.getLogin()
        );
        account.setPassword(
                accountDto.getPassword()
        );
        account.setEmail(
                accountDto.getEmail()
        );

        return account;
    }

    public AccountDto mapToDto(Account account) {
        AccountDto accountDto = new AccountDto();

        accountDto.setLogin(
                account.getLogin()
        );
        accountDto.setPassword(
                account.getPassword()
        );
        accountDto.setEmail(
                account.getEmail()
        );

        return accountDto;
    }
}

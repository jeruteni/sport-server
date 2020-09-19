package com.kstu.sport.services;

import com.kstu.sport.persistence.domain.Account;
import com.kstu.sport.persistence.dto.AccountDto;
import org.springframework.stereotype.Component;

//Пока тупо методы мапинга писать из дто в сущность и обратно.Потом можно интерфейс определить и по красоте делать
@Component
public class AccountMapper {

    public Account mapToEntity(AccountDto accountDto) {
        Account account = new Account();

        account.setUsername(
                accountDto.getUsername()
        );
        account.setPassword(
                accountDto.getPassword()
        );
        account.setEmail(
                accountDto.getEmail()
        );
        account.setFirstName(
                accountDto.getFirstName()
        );
        account.setMiddleName(
                accountDto.getMiddleName()
        );

        return account;
    }

    public AccountDto mapToDto(Account account) {
        AccountDto accountDto = new AccountDto();

        accountDto.setId(
                account.getId()
        );
        accountDto.setUsername(
                account.getUsername()
        );
        accountDto.setPassword(
                Account.PASSWORD
        );
        accountDto.setEmail(
                account.getEmail()
        );
        accountDto.setFirstName(
                account.getFirstName()
        );
        accountDto.setMiddleName(
                account.getMiddleName()
        );


        return accountDto;
    }
}

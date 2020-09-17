package com.kstu.sport.services;

import com.kstu.sport.persistence.dto.AccountDto;

public interface AccountService {

    // Сохранение и обновление пользователя(нужно красиво написать чтоб обновлялся.Либо выносить в два разных метода)
    void submit(AccountDto accountDto);

    AccountDto getAccountById(Long id);
}

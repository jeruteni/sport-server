package com.kstu.sport.controllers;

import com.kstu.sport.persistence.domain.Account;
import com.kstu.sport.persistence.dto.AccountDto;
import com.kstu.sport.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/submit")
    //TODO: переписать submit на обновление сущности пароль и тд
    public void submit(@RequestBody AccountDto accountDto) {
        accountService.submit(accountDto);
    }

    @GetMapping("/account")
    public AccountDto getAccount(@RequestParam(name = "accountId") Long accountId) {
        return accountService.getAccountById(accountId);
    }

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus register(@RequestBody AccountDto accountDto, HttpServletRequest request) {
        accountService.register(accountDto);
        return HttpStatus.OK;
    }
}

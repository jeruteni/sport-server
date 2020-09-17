package com.kstu.sport.controllers;

import com.kstu.sport.persistence.dto.AccountDto;
import com.kstu.sport.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/submit")
    public void submit(@RequestBody AccountDto accountDto) {
        accountService.submit(accountDto);
    }

    @GetMapping("/account")
    public AccountDto getAccount(@RequestParam(name = "accountId") Long accountId) {
        return accountService.getAccountById(accountId);
    }
}

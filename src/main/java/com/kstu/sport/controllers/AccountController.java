package com.kstu.sport.controllers;

import com.kstu.sport.persistence.dao.CustomerRepository;
import com.kstu.sport.persistence.domain.Account;
import com.kstu.sport.persistence.domain.Customer;
import com.kstu.sport.persistence.dto.AccountDto;
import com.kstu.sport.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;

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
    public Long register(@RequestBody AccountDto accountDto, HttpServletRequest request) {
      long accountId =  accountService.register(accountDto);
      return accountId;

    }

    @GetMapping("account/getCustomers/{account}")
    public List<Customer> getCustomers(@PathVariable Account account){

        return customerRepository.findAllByAccount(account);
    }
}

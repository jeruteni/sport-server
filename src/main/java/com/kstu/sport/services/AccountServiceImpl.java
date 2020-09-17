package com.kstu.sport.services;

import com.kstu.sport.persistence.dao.AccountRepository;
import com.kstu.sport.persistence.domain.Account;
import com.kstu.sport.persistence.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    //Кодировать пароль на будущее
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    //TODO сделать когда - нибудь simple dao через дженерики save/update/delete/ и тд через HibernateDaoSupport
    @Autowired
    private AccountRepository accountDao;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void submit(AccountDto accountDto) {
        Account account = userMapper.mapToEntity(accountDto);
        //Кодировать пароль в другом месте,так чисто для примера тут.По хорошему SecurityServiceImpl
        String password = bCryptPasswordEncoder.encode(account.getPassword());
        account.setPassword(password);

        accountDao.save(account);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        // Assert.notNull(id, "The given id must not be null!"); illegalArgumentException
        Account account = accountDao.getOne(id);
        return userMapper.mapToDto(account);
    }
}

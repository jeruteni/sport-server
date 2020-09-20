package com.kstu.sport.services;

import com.kstu.sport.persistence.dao.AccountRepository;
import com.kstu.sport.persistence.domain.Account;
import com.kstu.sport.persistence.dto.AccountDto;
import com.kstu.sport.persistence.dto.JwtAccountDto;
import com.kstu.sport.persistence.enums.AccountRole;
import com.kstu.sport.services.mapping.AccountMapper;
import org.apache.commons.collections4.SetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AccountServiceImpl implements AccountService {

    //Кодировать пароль на будущее
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    //TODO сделать когда - нибудь simple dao через дженерики save/update/delete/ и тд через HibernateDaoSupport
    @Autowired
    private AccountRepository accountDao;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Transactional
    public void submit(AccountDto accountDto) {
        Account account = accountMapper.mapToEntity(accountDto);
        //Кодировать пароль в другом месте,так чисто для примера тут.По хорошему SecurityServiceImpl
        String password = bCryptPasswordEncoder.encode(account.getPassword());
        account.setPassword(password);

        accountDao.save(account);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountDto getAccountById(Long id) {
        // Assert.notNull(id, "The given id must not be null!"); illegalArgumentException
        Account account = accountDao.getOne(id);
        return accountMapper.mapToDto(account);
    }

    @Override
    public UserDetails createUserDetails(Account account) {
        return new JwtAccountDto(
                account.getId(),
                account.getEmail(),
                account.getPassword(),
                account.getEnabled(),
                account.getRoles()
                );
    }

    @Override
    @Transactional(readOnly = true)
    public Account findByEmail(String email) {
        return accountDao.findByEmail(email);
    }

    @Override
    public void register(AccountDto accountDto) {
        boolean isAccountExist = checkAccountForExistsByEmail(accountDto.getEmail());
        if (isAccountExist)
            throw new IllegalArgumentException("There is an account with that email address:" + accountDto.getEmail());

        Account account = accountMapper.mapToEntity(accountDto);
        account.setRoles(SetUtils.hashSet(AccountRole.ADMIN));
        account.setEnabled(true);
        account.setPassword(bCryptPasswordEncoder.encode(accountDto.getPassword()));

        //TODO подтверждение почты
//        String appUrl = request.getContextPath();
//        eventPublisher.publishEvent(new OnRegistrationCompleteEvent
//                (registeredUser, request.getLocale(), appUrl));


        accountDao.save(account);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean checkAccountForExistsByEmail(String email) {
        return accountDao.countAccountByEmail(email) != 0;
    }
}

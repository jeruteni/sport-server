package com.kstu.sport.spring.loader;

import com.kstu.sport.persistence.dao.AccountRepository;
import com.kstu.sport.persistence.dao.SportsCategoryRepository;
import com.kstu.sport.persistence.domain.Account;
import com.kstu.sport.persistence.domain.SportsCategory;
import com.kstu.sport.persistence.enums.AccountRole;
import org.apache.commons.collections4.SetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Set;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    SportsCategoryRepository sportsCategoryRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        // Админ admin@yandex.ru admin
        createAccountIfNotFound("admin@yandex.ru","admin","Админ",
                "Админович","admin", SetUtils.hashSet(AccountRole.ADMIN));

        // Юзер user@yandex.ru user
        createAccountIfNotFound("user@yandex.ru","user","Юзер",
                "Юзерович","user", SetUtils.hashSet(AccountRole.USER));

        // Организатор organizer@yandex.ru organizer
        createAccountIfNotFound("organizer@yandex.ru","organizer","Организатор",
                "Организаторович","organizer", SetUtils.hashSet(AccountRole.ORGANIZER));

        fillSportCategoryRepo();
    }

    private void fillSportCategoryRepo() {

        String sportsCategoryList = "Football,Hockey,Basketball,Volleyball,Tennis,Swimming,Gymnastics,Box,Judo,Running";
        int counter = 0;

        if(sportsCategoryRepository.count() == 0){

            for(String sport : sportsCategoryList.split(",")){

                SportsCategory sportsCategory = new SportsCategory();
                sportsCategory.setCaption(sport);
                sportsCategory.setCategoryId(counter);

                sportsCategoryRepository.save(sportsCategory);
                counter++;
            }

        }
    }

    @Transactional
    Account createAccountIfNotFound(final String email, final String username, final String firstName, final String middleName, final String password,
                                    final Set<AccountRole> roles) {
        Account account = accountRepository.findByEmail(email);
        if (account == null) {
            account = new Account();
            account.setUsername(
                    username
            );
            account.setPassword(
                    passwordEncoder.encode(password)
            );
            account.setEmail(
                    email
            );
            account.setFirstName(
                    firstName
            );
            account.setMiddleName(
                    middleName
            );
        }
        account.setRoles(roles);
        account.setEnabled(true);
        account = accountRepository.save(account);
        return account;
    }

}

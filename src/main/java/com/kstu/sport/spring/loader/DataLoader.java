package com.kstu.sport.spring.loader;

import com.kstu.sport.persistence.dao.AccountRepository;
import com.kstu.sport.persistence.dao.CityRepository;
import com.kstu.sport.persistence.dao.SportsCategoryRepository;
import com.kstu.sport.persistence.dao.SportsComplexRepository;
import com.kstu.sport.persistence.domain.*;
import com.kstu.sport.persistence.enums.AccountRole;
import org.apache.commons.collections4.SetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SportsCategoryRepository sportsCategoryRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private SportsComplexRepository sportsComplexRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        // Админ admin@yandex.ru admin
        createAccountIfNotFound("admin@yandex.ru", "admin", "Админ",
                "Админович", "admin", SetUtils.hashSet(AccountRole.ADMIN));

        // Юзер user@yandex.ru user
        createAccountIfNotFound("user@yandex.ru", "user", "Юзер",
                "Юзерович", "user", SetUtils.hashSet(AccountRole.USER));

        // Организатор organizer@yandex.ru organizer
        createAccountIfNotFound("organizer@yandex.ru", "organizer", "Организатор",
                "Организаторович", "organizer", SetUtils.hashSet(AccountRole.ORGANIZER));

        fillSportCategoryRepo();

        fillCitiesRepo();

        createSportsComplexIfNotFound("Культурно-спортивный комплекс Уникс","ул. Профессора Нужина, 2/27",
                "+7 (843) 238-20-67",new GeoPoint(new BigDecimal("55.47"),new BigDecimal("49.06")),
                cityRepository.findByCaption("Казань"));

        createSportsComplexIfNotFound("Ак Барс Арена","просп. Ямашева, 115А, Казань",
                "+7 (843) 245-34-34",new GeoPoint(new BigDecimal("55.47"),new BigDecimal("50.06")),
                cityRepository.findByCaption("Казань"));


    }

    private void fillCitiesRepo() {
        List<String> cities = Arrays.asList("Казань", "Москва", "Альметьевск", "Киев", "Ульяновск", "Санкт-Петербург");
        cities.stream().filter(c -> !cityRepository.existsByCaption(c)).forEach(this::saveCity);
    }

    @Transactional
    void saveCity(String caption) {
        City city = new City();
        city.setCaption(caption);
        cityRepository.save(city);
    }

    private void fillSportCategoryRepo() {

        String sportsCategoryList = "Football,Hockey,Basketball,Volleyball,Tennis,Swimming,Gymnastics,Box,Judo,Running";
        long counter = 0;

        if (sportsCategoryRepository.count() == 0) {

            for (String sport : sportsCategoryList.split(",")) {

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

    private void createSportsComplexIfNotFound(String caption, String address, String phoneNumber,
                                               GeoPoint geoPoint, City city) {
        Long count = sportsComplexRepository.countByCaption(caption);
        if (count == 0) {
            SportsComplex sportsComplex = new SportsComplex();

            sportsComplex.setCaption(
                    caption
            );
            sportsComplex.setAddress(
                    address
            );
            sportsComplex.setPhoneNumber(
                    phoneNumber
            );
            sportsComplex.setGeoPoint(
                    geoPoint
            );
            sportsComplex.setCity(
                    city
            );
            sportsComplexRepository.save(sportsComplex);
        }


    }

}

package com.kstu.sport.services;

import com.kstu.sport.persistence.dao.AccountPreferencesRepository;
import com.kstu.sport.persistence.dao.AccountRepository;
import com.kstu.sport.persistence.dao.CategoryRepository;
import com.kstu.sport.persistence.domain.Account;
import com.kstu.sport.persistence.domain.AccountPreferences;
import com.kstu.sport.persistence.dto.CategoryDto;
import com.kstu.sport.services.mapping.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountPreferencesServiceImpl implements AccountPreferencesService {

    @Autowired
    private AccountPreferencesRepository accountPreferencesRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void savePreferences(Long id, List<CategoryDto> preferencesSportCategoryList) {
        Optional<Account> optionalAccount = accountRepository.findById(id);

        if (!optionalAccount.isPresent()) {
            throw new IllegalArgumentException("id is not valid");
        }

        preferencesSportCategoryList.stream().map(CategoryDto::getId).forEach(item -> {
            Long count = accountPreferencesRepository.countAccountPreferencesByAccountIdAndSportsCategoryId(optionalAccount.get().getId(),item);
            if (count == 0) {
                AccountPreferences accountPreferences = new AccountPreferences();
                accountPreferences.setAccount(optionalAccount.get());
                accountPreferences.setSportsCategory(categoryRepository.findByCategoryId(item).get());
                accountPreferencesRepository.save(accountPreferences);
            }
        });

    }
}
package com.kstu.sport.controllers;

import com.kstu.sport.persistence.dto.AccountPreferenceDto;
import com.kstu.sport.services.AccountPreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountPreferenceController {

    @Autowired
    private AccountPreferencesService accountPreferencesService;

    @PostMapping("account/preferences")
    public void savePreferences(@RequestBody AccountPreferenceDto accountPreferenceDto) {
        accountPreferencesService.savePreferences(accountPreferenceDto.getAccountId()
                ,accountPreferenceDto.getSportCategories());
    }
}

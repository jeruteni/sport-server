package com.kstu.sport.persistence.dto;

import java.util.ArrayList;
import java.util.List;

public class AccountPreferenceDto {

    private Long accountId;

    private List<CategoryDto> sportCategories = new ArrayList<>();

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public List<CategoryDto> getSportCategories() {
        return sportCategories;
    }

    public void setSportCategories(List<CategoryDto> sportCategories) {
        this.sportCategories = sportCategories;
    }
}

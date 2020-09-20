package com.kstu.sport.services;

import com.kstu.sport.persistence.dto.CategoryDto;

import java.util.List;

public interface AccountPreferencesService {
     void savePreferences(Long id, List<CategoryDto> preferencesSportCategoryList);
}

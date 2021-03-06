package com.kstu.sport.services.mapping;

import com.kstu.sport.persistence.domain.SportsCategory;
import com.kstu.sport.persistence.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDto mapToDto(SportsCategory sportsCategory) {
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(
                sportsCategory.getId()
        );
        categoryDto.setCaption(
                sportsCategory.getCaption()
        );
        categoryDto.setCategoryId(
                sportsCategory.getCategoryId()
        );

        return categoryDto;

    }

    public SportsCategory mapToEntity(CategoryDto categoryDto) {
        SportsCategory sportsCategory = new SportsCategory();

        sportsCategory.setId(
                categoryDto.getId()
        );
        sportsCategory.setCaption(
                categoryDto.getCaption()
        );
        sportsCategory.setCategoryId(
                categoryDto.getCategoryId()
        );

        return sportsCategory;

    }
}

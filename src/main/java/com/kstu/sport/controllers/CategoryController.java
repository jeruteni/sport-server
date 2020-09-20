package com.kstu.sport.controllers;

import com.kstu.sport.persistence.dto.CategoryDto;
import com.kstu.sport.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/fetchAll")
    public List<CategoryDto> fetchAll() {
        return categoryService.fetchAll();
    }

}

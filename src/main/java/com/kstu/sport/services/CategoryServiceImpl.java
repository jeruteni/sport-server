package com.kstu.sport.services;

import com.kstu.sport.persistence.dao.CategoryRepository;
import com.kstu.sport.persistence.dto.CategoryDto;
import com.kstu.sport.services.mapping.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDto> fetchAll() {
        return categoryRepository.findAll()
                .stream()
                .map(c -> categoryMapper.mapToDto(c))
                .collect(Collectors.toList());
    }
}

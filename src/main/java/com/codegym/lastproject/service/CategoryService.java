package com.codegym.lastproject.service;

import com.codegym.lastproject.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category findAllByNameContaining(String name, Pageable pageable);

    List<Category> findAll();

    Category findById(Long id);

    void saveCategory(Category category);

    void deleteCategory(Long id);
}
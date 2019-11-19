package com.codegym.lastproject.service;

import com.codegym.lastproject.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {
    Page<Category> findAllByNameContaining(String name, Pageable pageable);

    Page<Category> findAll(Pageable pageable);

    Optional<Category> findById(Long id);

    void save(Category director);

    void remove(Long id);
}
package com.codegym.lastproject.repository;

import com.codegym.lastproject.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findAllByNameContaining(String name, Pageable pageable);
}

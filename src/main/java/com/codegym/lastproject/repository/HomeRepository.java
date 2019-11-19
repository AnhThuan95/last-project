package com.codegym.lastproject.repository;

import com.codegym.lastproject.model.Home;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HomeRepository extends PagingAndSortingRepository<Home, Long> {
    Page<Home> findAllByAddressContaining(String address, Pageable pageable);
}

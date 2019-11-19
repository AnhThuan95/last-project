package com.codegym.lastproject.repository;

import com.codegym.lastproject.model.Home;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HomeRepository extends JpaRepository<Home, Long> {
    Home findAllByAddressContaining(String address, Pageable pageable);
    Home findByAddress(String address);
}

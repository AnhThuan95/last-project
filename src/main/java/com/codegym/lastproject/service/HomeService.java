package com.codegym.lastproject.service;

import com.codegym.lastproject.model.Home;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface HomeService {

    Page<Home> findAllByAddressContaining(String address, Pageable pageable);

    Page<Home> findAll(Pageable pageable);

    Optional<Home> findById(Long id);

    void save(Home home);

    void remove(Long id);
}

package com.codegym.lastproject.service;

import com.codegym.lastproject.model.Home;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface HomeService {

    Home findByAddress(String address);

    List<Home> findAll();

    Home findById(Long id);

    void saveHome(Home home);

    void deleteHome(Long id);
}

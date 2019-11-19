package com.codegym.lastproject.service.impl;

import com.codegym.lastproject.model.Home;
import com.codegym.lastproject.repository.HomeRepository;
import com.codegym.lastproject.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public Page<Home> findAllByAddressContaining(String address, Pageable pageable){
        return homeRepository.findAllByAddressContaining(address, pageable);
    }

    @Override
    public Page<Home> findAll(Pageable pageable) {
        return homeRepository.findAll(pageable);
    }

    @Override
    public Optional<Home> findById(Long id) {
        return homeRepository.findById(id);
    }

    @Override
    public void save(Home home) {
        homeRepository.save(home);
    }

    @Override
    public void remove(Long id) {
        homeRepository.deleteById(id);
    }

}

package com.codegym.lastproject.service.impl;

import com.codegym.lastproject.model.Home;
import com.codegym.lastproject.repository.HomeRepository;
import com.codegym.lastproject.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public Home findAllByAddressContaining(String address, Pageable pageable){
        return homeRepository.findAllByAddressContaining(address, pageable);
    }

    @Override
    public List<Home> findAll() {
        return homeRepository.findAll();
    }

    @Override
    public Home findById(Long id) {
        return homeRepository.findById(id).get();
    }

    @Override
    public void saveHome(Home home) {
        homeRepository.save(home);
    }

    @Override
    public void deleteHome(Long id) {
        homeRepository.deleteById(id);
    }

}

package com.codegym.lastproject.controller;

import com.codegym.lastproject.model.House;
import com.codegym.lastproject.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/guest")
public class GuestRestController {
    @Autowired
    private HouseService houseService;

    @GetMapping("/all")
    public ResponseEntity<List<House>> getListHouse() {
        List<House> houses = houseService.findAll();
        if (houses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping(value = "/host/{id}")
    public ResponseEntity<List<House>> getHostListHouse(@PathVariable("id") Long id) {
        List<House> houses = houseService.findByHostId(id);
        if (houses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<House> getHouse(@PathVariable("id") Long id) {
        House house = houseService.findById(id);
        if (house == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(house, HttpStatus.OK);
    }
}

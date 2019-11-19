package com.codegym.lastproject.controller;

import com.codegym.lastproject.model.Home;
import com.codegym.lastproject.service.CategoryService;
import com.codegym.lastproject.service.HomeService;
import com.codegym.lastproject.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class HomeRestController {

    @Autowired
    private HomeService homeService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/home/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Home>> listAllHomes() {
        List<Home> homes = homeService.findAll();
        if (homes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }

    @PostMapping(value = "/home/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> createHome(@RequestBody Home home) {
        Home originHome = homeService.findByAddress(home.getAddress());
        if (originHome != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        System.out.println("Creating Home " + home.getName());
        homeService.saveHome(home);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/home/delete/{id}")
    @ResponseBody
    public ResponseEntity<Void> apiDeleteHome(@PathVariable("id") Long id) {
        Home target = homeService.findById(id);

        if (target == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        homeService.deleteHome(target.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/home/edit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Home> updateHome(@PathVariable("id") Long id, @RequestBody Home home) {
        Home originHome = homeService.findById(id);

        if (originHome == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        originHome.setName(home.getName());
        originHome.setRoom(home.getRoom());
        originHome.setAddress(home.getAddress());
        originHome.setBedroom(home.getBedroom());
        originHome.setBathroom(home.getBathroom());
        originHome.setDescription(home.getDescription());
        originHome.setPriceByNight(home.getPriceByNight());

        homeService.saveHome(originHome);
        return new ResponseEntity<>(originHome, HttpStatus.OK);
    }
}
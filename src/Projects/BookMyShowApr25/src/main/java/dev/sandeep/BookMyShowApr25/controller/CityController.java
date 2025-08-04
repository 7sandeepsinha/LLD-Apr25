package dev.sandeep.BookMyShowApr25.controller;

import dev.sandeep.BookMyShowApr25.model.City;
import dev.sandeep.BookMyShowApr25.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/city")
    public ResponseEntity<City> createCity(@RequestBody City city) {
        return ResponseEntity.ok(cityService.save(city));
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<City> getCityById(@PathVariable int id) {
        return ResponseEntity.ok(cityService.getCityById(id));
    }

    @GetMapping("/city")
    public ResponseEntity<List<City>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

}

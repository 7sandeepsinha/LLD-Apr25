package dev.sandeep.BookMyShowApr25.service;

import dev.sandeep.BookMyShowApr25.exception.CityNotFoundException;
import dev.sandeep.BookMyShowApr25.model.City;
import dev.sandeep.BookMyShowApr25.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City save(City city) {
        return cityRepository.save(city);
    }

    public City getCityById(int id) {
        Optional<City> cityOptional = cityRepository.findById(id);
        if(cityOptional.isPresent()) {
            return cityOptional.get();
        } else {
            throw new CityNotFoundException("City id not found");
        }
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
}

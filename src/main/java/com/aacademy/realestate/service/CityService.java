package com.aacademy.realestate.service;

import com.aacademy.realestate.model.City;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface CityService {

    City findById(Long id);

    City save(City city);

    Set<City> findAll();

    City update (City city, Long id);

    void detachCityNeighborhood(Long cityId, Set<Long> neighborhoodIds);
}

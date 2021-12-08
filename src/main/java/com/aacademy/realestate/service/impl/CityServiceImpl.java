package com.aacademy.realestate.service.impl;

import com.aacademy.realestate.exception.ResourceNotFoundException;
import com.aacademy.realestate.model.City;
import com.aacademy.realestate.model.Neighborhood;
import com.aacademy.realestate.repository.CityRepository;
import com.aacademy.realestate.service.CityService;
import com.aacademy.realestate.service.NeighborhoodService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final NeighborhoodService neighborhoodService;

    public CityServiceImpl(CityRepository cityRepository, NeighborhoodService neighborhoodService) {
        this.cityRepository = cityRepository;
        this.neighborhoodService = neighborhoodService;
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City with id %d does not exits.", id)));
    }

    @Override
    public City save(City city) {

        Set<Neighborhood> neighborhoods = new HashSet<>();
        for (Neighborhood neighborhood: city.getNeighborhoods()) {
            Neighborhood foundNeighborhood = neighborhoodService.findById(neighborhood.getId());
            neighborhoods.add(foundNeighborhood);
        }

        return cityRepository.save(City.builder()
                .name(city.getName())
                .neighborhoods(neighborhoods)
                .build());
    }

    @Override
    public Set<City> findAll() {
        return null;
    }

    @Override
    public City update(City city, Long id) {
        City foundCity = findById(id);
        City cityToUpdate = City.builder()
                .id(foundCity.getId())
                .name(city.getName())
                .neighborhoods(city.getNeighborhoods())
                .build();

        return cityRepository.save(cityToUpdate);
    }

    @Override
    public void detachCityNeighborhood(Long cityId, Set<Long> neighborhoodIds) {
        City foundCity = findById(cityId);
        foundCity.getNeighborhoods()
                .removeIf(neighborhood -> neighborhoodIds.contains(neighborhood.getId()));

        cityRepository.save(foundCity);
    }
}

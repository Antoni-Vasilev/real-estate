package com.aacademy.realestate.service.impl;

import com.aacademy.realestate.model.City;
import com.aacademy.realestate.model.Estate;
import com.aacademy.realestate.model.EstateFeature;
import com.aacademy.realestate.model.Floor;
import com.aacademy.realestate.repository.EstateRepository;
import com.aacademy.realestate.service.CityService;
import com.aacademy.realestate.service.EstateFeatureService;
import com.aacademy.realestate.service.EstateService;
import com.aacademy.realestate.service.FloorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class EstateServiceImpl implements EstateService {

    private final EstateRepository estateRepository;
    private final EstateFeatureService estateFeatureService;
    private final CityService cityService;
    private final FloorService floorService;

    @Override
    public Estate save(Estate estate) {
        Set<EstateFeature> estateFeatures = new HashSet<>();
        for (EstateFeature estateFeature : estate.getEstateFeatures()) {
            EstateFeature foundEstateFeature = estateFeatureService.findById(estateFeature.getId());
            estateFeatures.add(foundEstateFeature);
        }
        City city = cityService.findById(estate.getId());
        Floor floor = floorService.findById(estate.getFloor().getId());

        estateRepository.save(Estate.builder()
                .id(estate.getId())
                .quadrature(estate.getQuadrature())
                .description(estate.getDescription())
                .floor(floor)
                .city(city)
                .estateFeatures(estateFeatures)
                .build());

        return null;
    }

    @Override
    public Set<Estate> findAll() {
        return new HashSet<>(estateRepository.findAll());
    }
}

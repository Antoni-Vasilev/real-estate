package com.aacademy.realestate.converter;

import com.aacademy.realestate.dto.CityDto;
import com.aacademy.realestate.model.City;
import com.aacademy.realestate.model.Neighborhood;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CityConverter {

    public CityDto toCityDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .neighborhood(city.getNeighborhoods()
                        .stream()
                        .map(Neighborhood::getId)
                        .collect(Collectors.toSet()))
                .build();
    }

    public City toCity(CityDto cityDto) {
        return City.builder()
                .id(cityDto.getId())
                .name(cityDto.getName())
                .neighborhoods(cityDto.getNeighborhood()
                        .stream()
                        .map((neighborhoodId) ->
                                Neighborhood.builder().id(neighborhoodId).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}

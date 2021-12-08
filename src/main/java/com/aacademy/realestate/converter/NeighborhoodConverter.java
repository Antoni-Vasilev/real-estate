package com.aacademy.realestate.converter;

import com.aacademy.realestate.dto.NeighborhoodDto;
import com.aacademy.realestate.model.Neighborhood;
import org.springframework.stereotype.Component;

@Component
public class NeighborhoodConverter {

    public NeighborhoodDto toNeighborhoodDto(Neighborhood neighborhood) {
        return NeighborhoodDto.builder()
                .id(neighborhood.getId())
                .name(neighborhood.getName())
                .build();
    }

    public Neighborhood toNeighborhood(NeighborhoodDto neighborhoodDto) {
        return Neighborhood.builder()
                .id(neighborhoodDto.getId())
                .name(neighborhoodDto.getName())
                .build();
    }
}

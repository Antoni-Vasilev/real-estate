package com.aacademy.realestate.converter;

import com.aacademy.realestate.dto.*;
import com.aacademy.realestate.model.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EstateConverter {

    public Estate toEstate(EstateDto estateDto) {
        return Estate.builder()
                .id(estateDto.getId())
                .city(City.builder()
                        .id(estateDto.getCityId())
                        .build())
                .floor(Floor.builder()
                        .id(estateDto.getFloorId())
                        .build())
                .description(estateDto.getDescription())
                .quadrature(Quadrature.builder()
                        .pureArea(estateDto.getPureArea())
                        .buildUpArea(estateDto.getBuiltArea())
                        .build())
                .estateFeatures(estateDto.getEstateFeaturesIds().stream()
                        .map(estateFeatureId -> EstateFeature.builder()
                                .id(estateFeatureId).build())
                        .collect(Collectors.toSet()))
                .build();
    }

    public EstateResponse toEstateResponse(Estate estate) {
        return EstateResponse.builder()
                .id(estate.getId())
                .builtUpArea(estate.getQuadrature().getBuildUpArea().toString())
                .pureArea(estate.getQuadrature().getPureArea().toString())
                .cityDto(CityDto.builder()
                        .id(estate.getCity().getId())
                        .name(estate.getCity().getName())
                        .build())
                .floorDto(FloorDto.builder()
                        .id(estate.getFloor().getId())
                        .number(estate.getFloor().getNumber())
                        .build())
                .estateFeatureDtoSet(estate.getEstateFeatures().stream().map(estateFeature ->
                        EstateFeatureDto.builder()
                                .id(estateFeature.getId())
                                .feature(estateFeature.getFeature())
                                .build()).collect(Collectors.toSet()))
                .description(estate.getDescription())
                .build();
    }
}

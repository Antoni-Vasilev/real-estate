package com.aacademy.realestate.dto;

import com.aacademy.realestate.model.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class EstateResponse {

    private Long id;

    private String builtUpArea;

    private String pureArea;

    private String description;

    private CityDto cityDto;

    private FloorDto floorDto;

    private Set<EstateFeatureDto> estateFeatureDtoSet;
}

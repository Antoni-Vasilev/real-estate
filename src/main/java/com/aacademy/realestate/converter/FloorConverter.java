package com.aacademy.realestate.converter;

import com.aacademy.realestate.dto.FloorDto;
import com.aacademy.realestate.model.Floor;
import org.springframework.stereotype.Component;

@Component
public class FloorConverter {

    public FloorDto toFloorDto(Floor floor) {
        return FloorDto.builder()
                .id(floor.getId())
                .number(floor.getNumber())
                .build();
    }

    public Floor toFloor(FloorDto floorDto) {
        return Floor.builder()
                .id(floorDto.getId())
                .number(floorDto.getNumber())
                .build();
    }
}

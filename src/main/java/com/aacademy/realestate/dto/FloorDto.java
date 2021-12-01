package com.aacademy.realestate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class FloorDto {

    private Long id;

    @Min(value = -3, message = "Floor number should be between -3.")
    @Max(value = 164, message = "Floor number must be below 164.")
    private Integer number;
}

package com.aacademy.realestate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Quadrature {

    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal buildUpArea;

    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal pureArea;

}

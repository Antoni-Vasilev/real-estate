package com.aacademy.realestate.controller;

import com.aacademy.realestate.converter.CityConverter;
import com.aacademy.realestate.dto.CityDto;
import com.aacademy.realestate.model.City;
import com.aacademy.realestate.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    private final CityService cityService;
    private final CityConverter cityConverter;

    public CityController(CityService cityService, CityConverter cityConverter) {
        this.cityService = cityService;
        this.cityConverter = cityConverter;
    }

    @PostMapping
    public ResponseEntity<CityDto> save(@RequestBody CityDto cityDto) {
        City city = cityConverter.toCity(cityDto);
        City savedCity = cityService.save(city);
        CityDto cityDtoRepository = cityConverter.toCityDto(savedCity);
        return ResponseEntity.ok(cityDtoRepository);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CityDto> findByName(@PathVariable Long id) {
        City byId = cityService.findById(id);
        CityDto cityDto = cityConverter.toCityDto(byId);

        return ResponseEntity.ok(cityDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CityDto> update(@RequestBody CityDto cityDto, @PathVariable Long id) {
        City city = cityConverter.toCity(cityDto);
        City savedCity = cityService.update(city, id);
        CityDto cityDtoRepository = cityConverter.toCityDto(savedCity);
        return ResponseEntity.ok(cityDtoRepository);
    }

//    @PutMapping("/")
//    public ResponseEntity<HttpStatus> detach(@RequestBody )
}

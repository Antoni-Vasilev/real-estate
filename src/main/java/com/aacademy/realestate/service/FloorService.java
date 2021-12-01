package com.aacademy.realestate.service;

import com.aacademy.realestate.model.Floor;

import java.util.Set;

public interface FloorService {

    Floor save(Floor floor);

    Floor findByNumber(Integer number);

    Floor update(Floor floor, Long id);

    void delete(Long id);

    Set<Floor> findAll();

    Floor findById(Long id);
}

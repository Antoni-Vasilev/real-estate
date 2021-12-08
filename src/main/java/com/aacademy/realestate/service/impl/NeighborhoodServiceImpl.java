package com.aacademy.realestate.service.impl;

import com.aacademy.realestate.exception.ResourceNotFoundException;
import com.aacademy.realestate.model.Neighborhood;
import com.aacademy.realestate.repository.NeighborhoodRepository;
import com.aacademy.realestate.service.NeighborhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class NeighborhoodServiceImpl implements NeighborhoodService {

    private final NeighborhoodRepository neighborhoodRepository;

    @Autowired
    public NeighborhoodServiceImpl(NeighborhoodRepository neighborhoodRepository) {
        this.neighborhoodRepository = neighborhoodRepository;
    }

    @Override
    public Neighborhood findById(Long id) {
        return neighborhoodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Neighborhood with name: %s does not exist.", id)));
    }

    @Override
    public Neighborhood findByName(String name) {
        return neighborhoodRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Neighborhood with name: %s does not exist.", name)));
    }

    @Override
    public Set<Neighborhood> findAll() {
        return new HashSet<>(neighborhoodRepository.findAll());
    }

    @Override
    public Neighborhood save(Neighborhood neighborhood) {
        return neighborhoodRepository.save(neighborhood);
    }
}

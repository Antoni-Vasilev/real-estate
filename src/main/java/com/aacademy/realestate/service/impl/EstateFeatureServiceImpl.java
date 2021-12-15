package com.aacademy.realestate.service.impl;

import com.aacademy.realestate.exception.ResourceNotFoundException;
import com.aacademy.realestate.model.EstateFeature;
import com.aacademy.realestate.repository.EstateFeatureRepository;
import com.aacademy.realestate.service.EstateFeatureService;
import lombok.AllArgsConstructor;
import org.hibernate.stat.internal.EntityStatisticsImpl;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstateFeatureServiceImpl implements EstateFeatureService {

    private final EstateFeatureRepository estateFeatureRepository;

    @Override
    public EstateFeature save(EstateFeature estateFeature) {
        return estateFeatureRepository.save(estateFeature);
    }

    @Override
    public EstateFeature findByFeature(String feature) {
        return null;
    }

    @Override
    public EstateFeature findById(Long id) {
        return estateFeatureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Feature with name %s does not exist", id)));
    }
}

package com.aacademy.realestate.service;

import com.aacademy.realestate.model.Estate;
import com.aacademy.realestate.model.EstateFeature;

public interface EstateFeatureService {
    EstateFeature save(EstateFeature estateFeature);

    EstateFeature findByFeature(String feature);

    EstateFeature findById(Long id);
}

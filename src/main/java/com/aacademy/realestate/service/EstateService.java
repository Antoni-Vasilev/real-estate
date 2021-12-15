package com.aacademy.realestate.service;

import com.aacademy.realestate.model.Estate;

import java.util.Set;

public interface EstateService {

    Estate save(Estate estate);

    Set<Estate> findAll();
}

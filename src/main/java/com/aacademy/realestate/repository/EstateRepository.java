package com.aacademy.realestate.repository;

import com.aacademy.realestate.model.Estate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstateRepository extends JpaRepository<Estate, Long> {

}

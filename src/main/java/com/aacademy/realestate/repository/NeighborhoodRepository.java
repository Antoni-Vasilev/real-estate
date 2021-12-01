package com.aacademy.realestate.repository;

import com.aacademy.realestate.model.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NeighborhoodRepository extends JpaRepository<Neighborhood, Long> {

    Optional<Neighborhood> findByName(String name);
}

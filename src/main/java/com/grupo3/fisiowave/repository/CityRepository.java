package com.grupo3.fisiowave.repository;

import com.grupo3.fisiowave.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
}

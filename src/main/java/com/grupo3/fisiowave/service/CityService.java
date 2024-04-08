package com.grupo3.fisiowave.service;

import com.grupo3.fisiowave.model.City;
import com.grupo3.fisiowave.repository.CityRepository;
import com.grupo3.fisiowave.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository repository;

    public List<City> findAllCities() {
        return repository.findAll();
    }

    public City findCityById(UUID id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("City not found for id: %s", id))
        );
    }

    public City save(City city) {
        return repository.save(city);

    }

    public City update(UUID id, City obj) {
        City city = repository.getOne(id);
        updateData(city, obj);
        return repository.save(city);

    }

    private void updateData(City city, City obj) {
        city.setName(obj.getName());
        city.setState(obj.getState());
    }


    public void deleteCityById(UUID id) {

        var city = findCityById(id);
        repository.delete(city);


    }
}


package com.grupo3.fisiowave.controller;

import com.grupo3.fisiowave.dto.CityResponse;
import com.grupo3.fisiowave.model.City;
import com.grupo3.fisiowave.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService service;

    @GetMapping
    public ResponseEntity<List<CityResponse>> findAllCities() {
        return ResponseEntity.ok(CityResponse.of(service.findAllCities()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponse> findCityByID(@PathVariable UUID id) {
        var city = service.findCityById(id);
        return ResponseEntity.ok(CityResponse.of(city));
    }

    @PostMapping
    public ResponseEntity<City> saveNewCity(@RequestBody City city) {
        city = service.save(city);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(city.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityResponse> updateCity(@PathVariable UUID id, @RequestBody City obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok(CityResponse.of(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable UUID id) {
        service.deleteCityById(id);
        return ResponseEntity.noContent().build();
    }
}


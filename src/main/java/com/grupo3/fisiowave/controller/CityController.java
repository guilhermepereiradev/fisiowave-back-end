package com.grupo3.fisiowave.controller;

import com.grupo3.fisiowave.dto.CityResponse;
import com.grupo3.fisiowave.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService service;

    @GetMapping
    public ResponseEntity<List<CityResponse>> findAllCities() {
        return ResponseEntity.ok(CityResponse.of(service.findAllCities()));
    }
}

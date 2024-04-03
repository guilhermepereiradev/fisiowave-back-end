package com.grupo3.fisiowave.controller;

import com.grupo3.fisiowave.dto.StateResponse;
import com.grupo3.fisiowave.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/states")
@RequiredArgsConstructor
public class StateController {

    private final StateService service;

    @GetMapping
    public ResponseEntity<List<StateResponse>> findAllStates() {
        return ResponseEntity.ok(StateResponse.of(service.findAllStates()));
    }
}

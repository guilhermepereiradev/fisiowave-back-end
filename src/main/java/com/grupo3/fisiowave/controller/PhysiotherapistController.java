package com.grupo3.fisiowave.controller;

import com.grupo3.fisiowave.dto.PhysiotherapistResumeResponse;
import com.grupo3.fisiowave.service.PhysiotherapistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/physiotherapists")
@RequiredArgsConstructor
public class PhysiotherapistController {

    private final PhysiotherapistService service;

    @GetMapping
    public ResponseEntity<List<PhysiotherapistResumeResponse>> findAll() {
        var physiotherapists = service.findAll();
        return ResponseEntity.ok(PhysiotherapistResumeResponse.of(physiotherapists));
    }

    @GetMapping(value = "/{id}", params = "availableOn")
    public ResponseEntity<Set<OffsetDateTime>> findAvailableTimes(@PathVariable UUID id, @RequestParam("availableOn") LocalDate date) {
        var availablePhysiotherapists = service.findAvailableTimes(date, id);
        return ResponseEntity.ok(availablePhysiotherapists);
    }
}

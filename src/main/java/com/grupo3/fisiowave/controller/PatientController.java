package com.grupo3.fisiowave.controller;

import com.grupo3.fisiowave.dto.AddressRequest;
import com.grupo3.fisiowave.dto.PatientRequest;
import com.grupo3.fisiowave.dto.PatientResponse;
import com.grupo3.fisiowave.dto.PatientResumeResponse;
import com.grupo3.fisiowave.model.Address;
import com.grupo3.fisiowave.model.Patient;
import com.grupo3.fisiowave.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResumeResponse>> findAllPatients() {
        return ResponseEntity.ok(PatientResumeResponse.of(patientService.findAllPatients()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> findPatientById(@PathVariable UUID id) {
        var patient = patientService.findPatientById(id);
        return ResponseEntity.ok(PatientResponse.of(patient));
    }

    @PostMapping
    public ResponseEntity<Void> saveNewPatient(@RequestBody @Valid PatientRequest request) {
        var patient = new Patient();
        request.copyToModel(patient);

        patient = patientService.save(patient);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}/address")
    public ResponseEntity<PatientResponse> updatePatientAddress(@PathVariable UUID id, @RequestBody @Valid AddressRequest request) {
        var address = new Address();
        request.copyToModel(address);

        var patient = patientService.updateAddress(id, address);

        return ResponseEntity.ok(PatientResponse.of(patient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        patientService.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }
}

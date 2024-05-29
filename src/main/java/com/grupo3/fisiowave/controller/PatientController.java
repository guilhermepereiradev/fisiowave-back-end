package com.grupo3.fisiowave.controller;

import com.grupo3.fisiowave.dto.*;
import com.grupo3.fisiowave.model.Address;
import com.grupo3.fisiowave.model.Anamnesis;
import com.grupo3.fisiowave.model.Patient;
import com.grupo3.fisiowave.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import static com.grupo3.fisiowave.config.SecurityExpressions.ADMIN_SCOPE;
import static com.grupo3.fisiowave.config.SecurityExpressions.CHECK_ID_OR_ADMIN_SCOPE;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping
    @PreAuthorize(ADMIN_SCOPE)
    public ResponseEntity<List<PatientResumeResponse>> findAllPatients() {
        return ResponseEntity.ok(PatientResumeResponse.of(patientService.findAllPatients()));
    }

    @GetMapping("/{id}")
    @PreAuthorize(CHECK_ID_OR_ADMIN_SCOPE)
    public ResponseEntity<PatientResponse> findPatientById(@PathVariable UUID id) {
        var patient = patientService.findPatientById(id);
        return ResponseEntity.ok(PatientResponse.of(patient));
    }

    @PostMapping
    public ResponseEntity<Void> saveNewPatient(@RequestBody @Valid PatientRequest request) {
        var patient = new Patient();
        request.copyToModel(patient, passwordEncoder);

        patient = patientService.save(patient);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}/address")
    @PreAuthorize(CHECK_ID_OR_ADMIN_SCOPE)
    public ResponseEntity<PatientResponse> updatePatientAddress(@PathVariable UUID id, @RequestBody @Valid AddressRequest request) {
        var address = new Address();
        request.copyToModel(address);

        var patient = patientService.updateAddress(id, address);

        return ResponseEntity.ok(PatientResponse.of(patient));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(CHECK_ID_OR_ADMIN_SCOPE)
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        patientService.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/anamnesis")
    @PreAuthorize(ADMIN_SCOPE)
    public ResponseEntity<PatientResponse> createAnamnesis(@PathVariable UUID id, @RequestBody AnamnesisRequest request) {
        var anamnesis = new Anamnesis();
        request.copyToModel(anamnesis);

        var patient = patientService.updateAnamnesis(id, anamnesis);

        return ResponseEntity.ok(PatientResponse.of(patient));
    }
}

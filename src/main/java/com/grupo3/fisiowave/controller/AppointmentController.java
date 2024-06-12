package com.grupo3.fisiowave.controller;

import com.grupo3.fisiowave.dto.AppointmentRequest;
import com.grupo3.fisiowave.dto.AppointmentResponse;
import com.grupo3.fisiowave.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

import static com.grupo3.fisiowave.config.SecurityExpressions.ADMIN_SCOPE;


@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService service;

    @PostMapping
    @PreAuthorize("#request.getPatientId().toString() == authentication.name or hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<AppointmentResponse> makeAppointment(@RequestBody @Valid AppointmentRequest request) {
        var appointment = service.makeAppointment(request.getPatientId(), request.getPhysiotherapistId(), request.getTime());
        return ResponseEntity.ok(AppointmentResponse.of(appointment));
    }

    @GetMapping("/physiotherapist/{id}")
    @PreAuthorize(ADMIN_SCOPE)
    public ResponseEntity<Set<AppointmentResponse>> getAppointmentsByPhysio(@PathVariable UUID id) {
        var appointments = service.getAppointmentsByPhysio(id);
        return ResponseEntity.ok(AppointmentResponse.of(appointments));
    }

    @PutMapping("/{id}")
    @PreAuthorize(ADMIN_SCOPE)
    public ResponseEntity<AppointmentResponse> updateObservation(@PathVariable UUID id, @RequestParam String observation) {
        var appointment = service.updateObservation(id, observation);
        return ResponseEntity.ok(AppointmentResponse.of(appointment));
    }

    @GetMapping("/{id}")
    @PreAuthorize(ADMIN_SCOPE)
    public ResponseEntity<AppointmentResponse> findById(@PathVariable UUID id) {
        var appointment = service.findById(id);
        return ResponseEntity.ok(AppointmentResponse.of(appointment));
    }
}

package com.grupo3.fisiowave.controller;

import com.grupo3.fisiowave.dto.AppointmentRequest;
import com.grupo3.fisiowave.dto.AppointmentResponse;
import com.grupo3.fisiowave.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


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
}

package com.grupo3.fisiowave.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class AppointmentRequest {

    @Future
    private OffsetDateTime time;
    @NotNull
    private UUID patientId;
    @NotNull
    private UUID physiotherapistId;
}

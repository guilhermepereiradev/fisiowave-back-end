package com.grupo3.fisiowave.dto;

import com.grupo3.fisiowave.model.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class AppointmentResumeResponse {

    private UUID id;
    private OffsetDateTime time;
    private PhysiotherapistResumeResponse physiotherapist;

    public static AppointmentResumeResponse of(Appointment appointment) {
        return new AppointmentResumeResponse(
                appointment.getId(),
                appointment.getTime(),
                PhysiotherapistResumeResponse.of(appointment.getPhysiotherapist())
        );
    }

    public static Set<AppointmentResumeResponse> of(Set<Appointment> appointments) {
        return appointments.stream().map(AppointmentResumeResponse::of).collect(Collectors.toSet());
    }
}

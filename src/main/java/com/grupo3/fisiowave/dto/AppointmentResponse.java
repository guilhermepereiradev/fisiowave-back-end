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
public class AppointmentResponse {

    private UUID id;
    private OffsetDateTime time;
    private PatientResumeResponse patient;
    private PhysiotherapistResumeResponse physiotherapist;

    public static AppointmentResponse of(Appointment appointment) {
        return new AppointmentResponse(
                appointment.getId(),
                appointment.getTime(),
                PatientResumeResponse.of(appointment.getPatient()),
                PhysiotherapistResumeResponse.of(appointment.getPhysiotherapist())
        );
    }

    public static Set<AppointmentResponse> of(Set<Appointment> appointments) {
        return appointments.stream().map(AppointmentResponse::of).collect(Collectors.toSet());
    }
}

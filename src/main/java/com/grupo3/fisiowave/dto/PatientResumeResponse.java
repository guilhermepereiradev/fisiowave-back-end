package com.grupo3.fisiowave.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo3.fisiowave.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PatientResumeResponse {

    private UUID id;
    private String name;
    private String phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String email;

    public static PatientResumeResponse of(Patient patient) {
        return new PatientResumeResponse(
                patient.getId(),
                patient.getName(),
                patient.getPhoneNumber(),
                patient.getBirthDate(),
                patient.getEmail()
        );
    }

    public static List<PatientResumeResponse> of(List<Patient> patients) {
        return patients.stream().map(PatientResumeResponse::of).toList();
    }
}

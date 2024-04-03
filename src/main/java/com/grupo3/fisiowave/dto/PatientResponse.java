package com.grupo3.fisiowave.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo3.fisiowave.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PatientResponse {

    private UUID id;
    private String name;
    private String phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String email;
    private AddressResponse address;

    public static PatientResponse of(Patient patient) {
        return new PatientResponse(
                patient.getId(),
                patient.getName(),
                patient.getPhoneNumber(),
                patient.getBirthDate(),
                patient.getEmail(),
                AddressResponse.of(patient.getAddress())
        );
    }
}

package com.grupo3.fisiowave.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo3.fisiowave.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private OffsetDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    private OffsetDateTime updateAt;
    private AddressResponse address;

    public static PatientResponse of(Patient patient) {
        return new PatientResponse(
                patient.getId(),
                patient.getName(),
                patient.getPhoneNumber(),
                patient.getBirthDate(),
                patient.getEmail(),
                patient.getCreatedAt(),
                patient.getUpdateAt(),
                AddressResponse.of(patient.getAddress())
        );
    }
}

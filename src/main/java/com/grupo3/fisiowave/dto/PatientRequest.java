package com.grupo3.fisiowave.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo3.fisiowave.model.Address;
import com.grupo3.fisiowave.model.Patient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
@Data
public class PatientRequest {

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 9, max = 14)
    private String phoneNumber;

    @NotNull
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @Valid
    private AddressRequest address;

    public void copyToModel(Patient patient) {
        patient.setName(this.name);
        patient.setPhoneNumber(this.phoneNumber);
        patient.setBirthDate(this.birthDate);
        patient.setEmail(this.email);

        if (this.address != null) {
            var newAddress = new Address();
            this.address.copyToModel(newAddress);

            patient.setAddress(newAddress);
        }
    }
}

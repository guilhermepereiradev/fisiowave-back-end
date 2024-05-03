package com.grupo3.fisiowave.dto;

import com.grupo3.fisiowave.model.Address;
import com.grupo3.fisiowave.model.Patient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
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

    @NotBlank
    private String password;

    @Valid
    private AddressRequest address;

    public void copyToModel(Patient patient, PasswordEncoder passwordEncoder) {
        patient.setName(getName());
        patient.setPhoneNumber(getPhoneNumber());
        patient.setBirthDate(getBirthDate());
        patient.setEmail(getEmail());
        patient.setPassword(passwordEncoder.encode(getPassword()));

        if (getAddress() != null && getAddress().getCity().getId() != null) {
            var newAddress = new Address();
            getAddress().copyToModel(newAddress);

            patient.setAddress(newAddress);
        }
    }
}

package com.grupo3.fisiowave.service;

import com.grupo3.fisiowave.model.Patient;
import com.grupo3.fisiowave.repository.PatientRepository;
import com.grupo3.fisiowave.service.exception.ResourceNotFoundException;
import com.grupo3.fisiowave.service.exception.ValidateException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;
    private final CityService cityService;

    public List<Patient> findAllPatients() {
        return repository.findAll();
    }

    public Patient findPatientById(UUID id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Patient not found for id: %s", id))
        );
    }

    @Transactional
    public Patient save(Patient patient) {
        validatePatient(patient);

        if(patient.getAddress() != null) {
            var city = cityService.findCityById(patient.getAddress().getCity().getId());
            patient.getAddress().setCity(city);
        }

        return repository.save(patient);
    }

    public void validatePatient(Patient patient) {
        if(repository.existsByEmail(patient.getEmail())) {
            throw new ValidateException(String.format("Email '%s' already is in use.", patient.getEmail()));
        }
    }

    public void deletePatientById(UUID id) {
        var patient = findPatientById(id);
        repository.delete(patient);
    }
}

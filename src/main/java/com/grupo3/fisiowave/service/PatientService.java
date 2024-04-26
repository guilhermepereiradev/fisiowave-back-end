package com.grupo3.fisiowave.service;

import com.grupo3.fisiowave.model.Address;
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
                () -> new ResourceNotFoundException(String.format("Paciente não encontrado para id: %s", id))
        );
    }

    @Transactional
    public Patient save(Patient patient) {
        validatePatient(patient);
        syncCityWithAddress(patient.getAddress());

        return repository.save(patient);
    }

    @Transactional
    public Patient updateAddress(UUID id, Address address) {
        syncCityWithAddress(address);

        var patient = findPatientById(id);
        patient.setAddress(address);

        return patient;
    }

    public void deletePatientById(UUID id) {
        var patient = findPatientById(id);
        repository.delete(patient);
    }

    public void validatePatient(Patient patient) {
        if(repository.existsByEmail(patient.getEmail())) {
            throw new ValidateException(String.format("E-mail '%s' já está em uso.", patient.getEmail()));
        }
    }

    public void syncCityWithAddress(Address address) {
        if(address != null) {
            var city = cityService.findCityById(address.getCity().getId());
            address.setCity(city);
        }
    }
}

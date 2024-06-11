package com.grupo3.fisiowave.service;

import com.grupo3.fisiowave.model.Appointment;
import com.grupo3.fisiowave.repository.AppointmentRepository;
import com.grupo3.fisiowave.service.exception.ResourceNotFoundException;
import com.grupo3.fisiowave.service.exception.ValidateException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository repository;
    private final PatientService patientService;
    private final PhysiotherapistService physiotherapistService;
    private final DateService dateService;

    @Transactional
    public Appointment makeAppointment(UUID patientId, UUID physiotherapistId, OffsetDateTime time) {
        dateService.validadeDate(time.toLocalDate());

        var physiotherapist = physiotherapistService.findAvailableById(physiotherapistId, time);
        var patient = patientService.findPatientById(patientId);

        var appointment = new Appointment();
        appointment.setTime(time);
        appointment.setPatient(patient);
        appointment.setPhysiotherapist(physiotherapist);

        return repository.save(appointment);
    }

    public Set<Appointment> getAppointmentsByPhysio(UUID id) {
        return repository.findByPhysiotherapistId(id);
    }

    @Transactional
    public Appointment updateObservation(UUID id, String observation) {
        if (observation == null || observation.length() > 1000) {
            throw new ValidateException("Observação não é um valor valido");
        }

        var appointment = findById(id);
        appointment.setObservation(observation);

        return appointment;
    }

    public Appointment findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Sessão não encontrada para id: %s", id)));
    }
}

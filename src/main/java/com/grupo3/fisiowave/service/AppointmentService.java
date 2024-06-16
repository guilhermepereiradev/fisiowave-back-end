package com.grupo3.fisiowave.service;

import com.grupo3.fisiowave.model.Appointment;
import com.grupo3.fisiowave.model.Patient;
import com.grupo3.fisiowave.model.Physiotherapist;
import com.grupo3.fisiowave.model.dto.BookAppointmentConfirmationEmailDto;
import com.grupo3.fisiowave.repository.AppointmentRepository;
import com.grupo3.fisiowave.service.exception.ResourceNotFoundException;
import com.grupo3.fisiowave.service.exception.ValidateException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository repository;
    private final PatientService patientService;
    private final PhysiotherapistService physiotherapistService;
    private final DateService dateService;
    private final EmailService emailService;

    @Transactional
    public Appointment makeAppointment(UUID patientId, UUID physiotherapistId, OffsetDateTime time) {
        dateService.validadeDate(time.toLocalDate());

        var physiotherapist = physiotherapistService.findAvailableById(physiotherapistId, time);
        var patient = patientService.findPatientById(patientId);

        var appointment = new Appointment();
        appointment.setTime(time);
        appointment.setPatient(patient);
        appointment.setPhysiotherapist(physiotherapist);

        appointment = repository.save(appointment);

        sendConfirmationEmail(patient, appointment.getTime(), physiotherapist);

        return appointment;
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

    private void sendConfirmationEmail(Patient patient, OffsetDateTime time, Physiotherapist physiotherapist) {
        var variables = new HashMap<String, Object>();
        variables.put("patientName", patient.getName());
        variables.put("date", time.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        variables.put("time", time.toLocalTime().minusHours(3).format(DateTimeFormatter.ofPattern("HH:mm")));
        variables.put("physioName", physiotherapist.getName());

        var emailDto = BookAppointmentConfirmationEmailDto.builder()
                .recipient(patient.getEmail())
                .subject("FisioWave - Sessão marcada com sucesso")
                .variables(variables)
                .build();

        emailService.send(emailDto);
    }
}

package com.grupo3.fisiowave.service;

import com.grupo3.fisiowave.model.Physiotherapist;
import com.grupo3.fisiowave.repository.AppointmentRepository;
import com.grupo3.fisiowave.repository.PhysiotherapistRepository;
import com.grupo3.fisiowave.service.exception.ResourceNotFoundException;
import com.grupo3.fisiowave.service.exception.ValidateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhysiotherapistService {

    private final PhysiotherapistRepository repository;
    private final AppointmentRepository appointmentRepository;
    private final DateService dateService;

    public List<Physiotherapist> findAll() {
        return repository.findAll();
    }

    public Physiotherapist findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(String.format("Fisioterapeuta não encontrado para id: %s", id))
                );
    }

    public Physiotherapist findAvailableById(UUID id, OffsetDateTime time) {
        var physiotherapist = findById(id);
        validatePhysiotherapistAvailable(physiotherapist.getId(), time);
        return physiotherapist;
    }

    private void validatePhysiotherapistAvailable(UUID id, OffsetDateTime time) {
        var thirtyMinutes = 30L;
        var minTime = time.minusMinutes(thirtyMinutes);
        var maxTime = time.plusMinutes(thirtyMinutes);
        if (repository.verifyNotAvailable(id, minTime, maxTime)) {
            throw new ValidateException("Fisioterapeuta não disponível para esse horário");
        }
    }

    public Set<OffsetDateTime> findAvailableTimes(LocalDate date, UUID id) {
        var availableTimes = dateService.initializeAllAvailableTimesPerDay(date);
        var notAvailableTimes = appointmentRepository.findAppointmentForDateByPhysioId(date, id);

        if (notAvailableTimes.isEmpty()) return availableTimes;

        availableTimes.removeIf(availableTime -> {
            for (var notAvailableTime : notAvailableTimes) {
                var minTime = availableTime.minusMinutes(30);
                var maxTime = availableTime.plusMinutes(30);
                if (notAvailableTime.isAfter(minTime) && notAvailableTime.isBefore(maxTime)) {
                    return true;
                }
            }
            return false;
        });

        return availableTimes;
    }
}

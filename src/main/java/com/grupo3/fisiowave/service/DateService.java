package com.grupo3.fisiowave.service;

import com.grupo3.fisiowave.service.exception.ValidateException;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Service
public class DateService {

    public Set<OffsetDateTime> initializeAllAvailableTimesPerDay(LocalDate date) {
        validadeDate(date);

        var availableTimes = new HashSet<OffsetDateTime>();
        var start = LocalTime.of(8, 0);
        var end = LocalTime.of(17, 0);
        for (var time = start; time.isBefore(end); time = time.plusHours(1)) {
            availableTimes.add(OffsetDateTime.of(date, time, ZoneOffset.of("-03:00")));
        }

        availableTimes.remove(OffsetDateTime.of(date, LocalTime.of(12, 0), ZoneOffset.UTC));

        return new TreeSet<>(availableTimes);
    }

    public void validadeDate(LocalDate date) {
        if (date.isBefore(LocalDate.now())) {
            throw new ValidateException("Data da consulta deve ser uma data futura");
        }

        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            throw new ValidateException("Não é possível marcar consultas aos fins de semana.");
        }
    }
}

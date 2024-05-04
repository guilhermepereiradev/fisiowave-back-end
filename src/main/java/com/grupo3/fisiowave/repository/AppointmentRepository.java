package com.grupo3.fisiowave.repository;

import com.grupo3.fisiowave.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {

    @Query("select distinct(a.time) from Appointment a where date(a.time) = :date and a.physiotherapist.id = :physioId")
    Set<OffsetDateTime> findAppointmentForDateByPhysioId(LocalDate date, UUID physioId);
}

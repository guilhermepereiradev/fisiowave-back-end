package com.grupo3.fisiowave.repository;

import com.grupo3.fisiowave.model.Physiotherapist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.OffsetDateTime;
import java.util.UUID;

public interface PhysiotherapistRepository extends JpaRepository<Physiotherapist, UUID> {


    @Query("select case when count(a) > 0 then true else false end " +
            "from Appointment a " +
            "where " +
            "a.physiotherapist.id = :physioId and " +
            "a.time between :minTime and :maxTime"
    )
    boolean verifyNotAvailable(UUID physioId, OffsetDateTime minTime, OffsetDateTime maxTime);
}

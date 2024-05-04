package com.grupo3.fisiowave.dto;

import com.grupo3.fisiowave.model.Physiotherapist;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PhysiotherapistResumeResponse {

    private UUID id;
    private String name;
    private String email;

    public static PhysiotherapistResumeResponse of(Physiotherapist physiotherapist) {
        return new PhysiotherapistResumeResponse(
                physiotherapist.getId(),
                physiotherapist.getName(),
                physiotherapist.getEmail()
        );
    }

    public static List<PhysiotherapistResumeResponse> of(List<Physiotherapist> physiotherapists) {
        return physiotherapists.stream().map(PhysiotherapistResumeResponse::of).toList();
    }
}

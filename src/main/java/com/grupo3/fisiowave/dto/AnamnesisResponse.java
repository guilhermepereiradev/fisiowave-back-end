package com.grupo3.fisiowave.dto;

import com.grupo3.fisiowave.model.Anamnesis;
import com.grupo3.fisiowave.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnamnesisResponse {

    private UUID id;
    private Gender gender;
    private String profession;
    private BigDecimal weight;
    private BigDecimal height;
    private String chiefComplaint;
    private String pastMedicalHistory;
    private String currentMedications;
    private String observation;


    public static AnamnesisResponse of(Anamnesis anamnesis) {
        if (anamnesis == null) {
            return new AnamnesisResponse();
        }
        return new AnamnesisResponse(
                anamnesis.getId(),
                anamnesis.getGender(),
                anamnesis.getProfession(),
                anamnesis.getWeight(),
                anamnesis.getHeight(),
                anamnesis.getChiefComplaint(),
                anamnesis.getPastMedicalHistory(),
                anamnesis.getCurrentMedications(),
                anamnesis.getObservation()
        );
    }
}
